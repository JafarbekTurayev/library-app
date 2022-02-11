package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.projection.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository
        extends JpaRepository<Book, Integer> {

    //kutubxona tegishli kitoblar
    List<BookProjection> findAllByLibrary_Id(Integer id);

    //search
//    List<Book> findAllByNameContains(String name);
    List<Book> findAllByNameContainingIgnoreCase(String name);
//    List<BookProjection> findAllByNameContains(String name);


}
