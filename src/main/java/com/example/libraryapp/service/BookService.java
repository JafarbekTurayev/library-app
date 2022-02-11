package com.example.libraryapp.service;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.BookDTO;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.entity.Library;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.repository.CategoryRepository;
import com.example.libraryapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(BookDTO bookDTO) {

        Optional<Library> optionalLibrary = libraryRepository.findById(bookDTO.getLibraryId());
        List<Category> allById = categoryRepository.findAllById(bookDTO.getCategoryIds());

        if (!optionalLibrary.isPresent()) return new ApiResponse("xato", false);

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setLibrary(optionalLibrary.get());
        book.setCategoryList(allById);

        Book save = bookRepository.save(book);
        return new ApiResponse("Mana", true, save);
    }

    public ApiResponse getAll() {
        return new ApiResponse("Mana listi", true, bookRepository.findAll());

    }

    public ApiResponse getOne(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        return new ApiResponse("ONe", true, byId.get());
    }

    public ApiResponse edit(Integer id, BookDTO dto) {
        Optional<Book> byId = bookRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("xatolik", false);
        }
        Book book = byId.get();
        book.setName(dto.getName());

        List<Category> allById = categoryRepository.findAllById(dto.getCategoryIds());
        book.setCategoryList(allById);
        Optional<Library> byId1 = libraryRepository.findById(dto.getLibraryId());
        book.setLibrary(byId1.get());
        bookRepository.save(book);
        return new ApiResponse("EDIT!", true);
    }

    public ApiResponse delete(Integer id) {
        if (!bookRepository.existsById(id)) return new ApiResponse("Xatolik", false);
        bookRepository.deleteById(id);
        return new ApiResponse("Delete", true);
    }
}
