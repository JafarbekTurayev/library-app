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
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    Categoryservice categoryservice;
    @Autowired
    CategoryRepository categoryRepository;

//    @GetMapping("/date")
//    public Slice<Category> getDate(
//            @RequestParam(value = "begin", defaultValue = AppConstants.DEFAULT_BEGIN_DATE) String begin,
//            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) String end) {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsedBeginDate = null;
//        Date parsedEndDate = null;
//        try {
//            parsedBeginDate = dateFormat.parse(begin);
//            parsedEndDate = dateFormat.parse(end);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Timestamp timestamp = new java.sql.Timestamp(parsedBeginDate.getTime());
//        Timestamp timestamp1 = new java.sql.Timestamp(parsedEndDate.getTime());
//
//        return categoryRepository.findAllByCreatedAtBetween(PageRequest.of(0, 2), timestamp, timestamp1);
//
//    }

//    @GetMapping("/pageable")
//    public Page<Category> getByPageable(
//            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
//            @RequestParam(value = "sort", defaultValue = "id") String sort,
//            @RequestParam(value = "begin", defaultValue = AppConstants.DEFAULT_BEGIN_DATE) Timestamp begin,
//            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) Timestamp end
//    ) {
//
//        return categoryRepository.findAllByCreatedAtBetween(PageRequest.of(page, size, Sort.by(sort)), begin, end);
//    }

//    @GetMapping("/jpql/{id}")
//    public Category getOne(@PathVariable Integer id) {
//        return categoryRepository.getOneByIdJpql(id).get();
//    }

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
