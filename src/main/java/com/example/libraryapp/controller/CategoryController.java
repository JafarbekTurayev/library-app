package com.example.libraryapp.controller;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.CategoryDTO;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    Categoryservice categoryservice;

    @GetMapping("/list")
    public List<Category> getAll() {
        return categoryservice.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return categoryservice.getById(id);
    }

    @PostMapping("")
    public ApiResponse addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryservice.add(categoryDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse editCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
        return categoryservice.edit(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        return categoryservice.delete(id);
    }

}
