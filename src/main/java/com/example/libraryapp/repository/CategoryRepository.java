package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {


    List<Category> findAllByNameContaining(String name);

//    @Override
//    Page<Category> findAll(Pageable pageable);


//    Page<Category> findAllByCreatedAtBetween(Timestamp begin, Timestamp end);

    Page<Category> findAllByCreatedAtBetween(Pageable pageable, Timestamp begin, Timestamp end);


//    Pageable page bet 0 1 2  size 10 20 5 2

//    @Override
//    Page<Category> findAll(Pageable pageable, Sort sort);
}
