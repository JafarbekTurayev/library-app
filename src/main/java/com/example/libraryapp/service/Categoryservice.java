package com.example.libraryapp.service;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.CategoryDTO;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categoryservice {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public ApiResponse getById(Integer id) {
//        Category byId = categoryRepository.getById(id);
        Optional<Category> byId = categoryRepository.findById(id);
        return new ApiResponse("Show", true, byId);
    }

    public ApiResponse add(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        Category save = categoryRepository.save(category);

        return new ApiResponse("Added", true, save);

    }

    public ApiResponse edit(Integer id, CategoryDTO categoryDTO) {

        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This category does not exist",
                false, null);
        Category category = byId.get();
        category.setName(categoryDTO.getName());
        Category save = categoryRepository.save(category);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        if (!categoryRepository.existsById(id)) return new ApiResponse("Xatolik!", false);
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted!", true);
    }
}
