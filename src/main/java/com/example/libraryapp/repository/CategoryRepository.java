package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {

}
