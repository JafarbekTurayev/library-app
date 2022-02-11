package com.example.libraryapp.mvc;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.LibraryDto;
import com.example.libraryapp.entity.Library;
import com.example.libraryapp.repository.LibraryRepository;
import com.example.libraryapp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/library/admin")
public class LibraryPageController {

    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    LibraryService libraryService;

    @GetMapping
    public String getLib(Model model) {
        model.addAttribute("libraries", libraryRepository.findAll());
        return "admin-lib";
    }

    @GetMapping("/{id}")
    public String getOneLibPage(@PathVariable Integer id, Model model) {
        Optional<Library> byId = libraryRepository.findById(id);
        Library library = byId.get();
        model.addAttribute("ketmon", library);
        return "lib-details";
    }

    @GetMapping("/add")
    public String addLibPage() {
        return "add-lib";
    }

    @PostMapping("/add")
    public String addLibSave(@ModelAttribute LibraryDto dto) {
        libraryService.add(dto);
        return "redirect:/library/admin";
//        return "admin-lib";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("library", libraryRepository.findById(id).get());
        return "lib-edit";
    }

    @PostMapping("/edit/{id}")
    public String editLibSave(@PathVariable Integer id, @ModelAttribute LibraryDto dto) {
        libraryService.edit(id, dto);
        return "redirect:/library/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteLib(@PathVariable Integer id) {
        libraryService.delete(id);
        return "redirect:/library/admin";
    }

}
