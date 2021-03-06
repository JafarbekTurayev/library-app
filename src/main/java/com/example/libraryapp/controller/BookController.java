package com.example.libraryapp.controller;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.BookDTO;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.projection.BookProjection;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.repository.CategoryRepository;
import com.example.libraryapp.repository.LibraryRepository;
import com.example.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

//    @GetMapping("/list")
//    public List<Book> get(@RequestParam String name) {
////        List<Category> allById = categoryRepository.findAllById(ids);
////        return bookRepository.getBooksByCategoryList(name);
//    }

    @GetMapping("/list")
    public List<Book> getAll(@RequestParam List<Integer> ids) {
        return bookRepository.findAllByCategoryListIn(ids);
    }


    @PostMapping
    public ApiResponse add(@RequestBody BookDTO bookDTO) {
        return bookService.add(bookDTO);
    }

    @GetMapping
    public ApiResponse getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        return bookService.getOne(id);
    }


    @GetMapping("/libraryId/{id}")
    public ApiResponse getByLibraryId(@PathVariable Integer id) {
        return bookService.getAllByLibraryId(id);
    }

    //search?name=""
    @GetMapping("/search")
    public List<BookProjection> search(@RequestParam String name) {
//        return new ApiResponse("Ma", true,
//        return bookRepository.findAllByNameContains(name);
        return null;
    }
}
