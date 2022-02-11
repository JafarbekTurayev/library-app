package com.example.libraryapp.controller;

import com.example.libraryapp.LibraryAppApplication;
import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.LibraryDto;
import com.example.libraryapp.entity.Library;
import com.example.libraryapp.repository.LibraryRepository;
import com.example.libraryapp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    LibraryService libraryService;

    @PostMapping()
    public ApiResponse add(@RequestBody LibraryDto libraryDto) {
        return libraryService.add(libraryDto);
    }

    @GetMapping()
    public ApiResponse getAll() {
        return libraryService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return libraryService.getById(id);
    }


    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody LibraryDto libraryDto) {
        return libraryService.edit(id, libraryDto);
    }

    @GetMapping("/search")
    public ApiResponse search(@RequestParam String name,
                              @RequestParam String city) {
        return new ApiResponse("Ma", true,
                libraryRepository.findAllByNameContainsOrAddress_CityContains(name, city));
    }

}
