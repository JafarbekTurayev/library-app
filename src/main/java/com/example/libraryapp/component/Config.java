package com.example.libraryapp.component;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.UUID;

@Configuration
public class Config {

    @Autowired
    CategoryRepository categoryRepository;

    @Bean
    public void run() {
        System.out.println("Oddiy ishladi!");
        Category category1 = new Category("YAnGI");
        categoryRepository.save(category1);
    }

    @Bean
    @Lazy
    public void start() {
        System.out.println("Lazy ishladi");
        Category category = new Category("Komediya");
        categoryRepository.save(category);

    }
}
