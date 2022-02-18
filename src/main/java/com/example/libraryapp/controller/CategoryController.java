package com.example.libraryapp.controller;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.CategoryDTO;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.repository.CategoryRepository;
import com.example.libraryapp.service.Categoryservice;
import com.example.libraryapp.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    Categoryservice categoryservice;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/pageable")
    public Page<Category> getByPageable(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort,
            @RequestParam(value = "begin", defaultValue = AppConstants.DEFAULT_BEGIN_DATE) Timestamp begin,
            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) Timestamp end
    ) {

        return categoryRepository.findAllByCreatedAtBetween(PageRequest.of(page, size, Sort.by(sort)), begin, end);
    }

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
