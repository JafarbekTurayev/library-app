package com.example.libraryapp.mvc;

import com.example.libraryapp.dto.BookDTO;
import com.example.libraryapp.dto.LibraryDto;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Library;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.repository.CategoryRepository;
import com.example.libraryapp.repository.LibraryRepository;
import com.example.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/book/admin")
public class BookPageController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookService bookService;

    @GetMapping("/search")
    public String search(Model model, @RequestParam String name) {
        model.addAttribute("books", bookRepository.findAllByNameContainingIgnoreCase(name));
//        model.addAttribute("categoryList", bookRepository.findAllByNameContains(name));
//        model.addAttribute("books", bookRepository.fi0 = {$Proxy136@13732} ndAllByNameContains(name));
        return "admin-book";
    }

    @GetMapping
    public String getBook(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "admin-book";
    }

    @GetMapping("/{id}")
    public String getOneBookPage(@PathVariable Integer id, Model model) {
        Optional<Book> byId = bookRepository.findById(id);
        Book book = byId.get();
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping("/add")
    public String addLibPage(Model model) {
        model.addAttribute("libraryList", libraryRepository.findAll());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBookSave(@ModelAttribute BookDTO dto) {
        bookService.add(dto);
        return "redirect:/book/admin";
//        return "admin-lib";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("libraryList", libraryRepository.findAll());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "book-edit";
    }

    @PostMapping("/edit/{id}")
    public String editLibSave(@PathVariable Integer id, @ModelAttribute BookDTO dto) {
        bookService.edit(id, dto);
        return "redirect:/book/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteLib(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/book/admin";
    }
}
