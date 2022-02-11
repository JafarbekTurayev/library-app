package com.example.libraryapp.service;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.dto.LibraryDto;
import com.example.libraryapp.entity.Address;
import com.example.libraryapp.entity.Library;
import com.example.libraryapp.repository.AddressRepository;
import com.example.libraryapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service

public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    AddressRepository addressRepository;

    public ApiResponse add(@RequestBody LibraryDto libraryDto) {
        Library library = new Library();
        library.setName(libraryDto.getName());
        Address address = new Address();
        address.setCity(libraryDto.getCity());
        address.setHome(libraryDto.getHome());
        address.setStreet(libraryDto.getStreet());
        Address save = addressRepository.save(address);
        library.setAddress(save);
        Library save1 = libraryRepository.save(library);
        return new ApiResponse("Added", true, save1);

    }

    public ApiResponse getAll() {
        return new ApiResponse
                ("Mana", true, libraryRepository.findAll());
    }

    public ApiResponse getById(Integer id) {
        Optional<Library> byId = libraryRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Xatolik", false);
        return new ApiResponse
                ("Mana", true, byId.get());
    }

    public ApiResponse edit(Integer id, LibraryDto libraryDto) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        Library editedLibrary = optionalLibrary.get();
        Address address = editedLibrary.getAddress();
        address.setStreet(libraryDto.getStreet());
        address.setCity(libraryDto.getCity());
        address.setHome(libraryDto.getHome());

        addressRepository.save(address);

        editedLibrary.setName(libraryDto.getName());
        editedLibrary.setAddress(address);
        libraryRepository.save(editedLibrary);
        return new ApiResponse("Edited!", true);
    }

    public ApiResponse delete(Integer id) {
        if (!libraryRepository.existsById(id)) return new ApiResponse("Xatolik!", false);

        libraryRepository.deleteById(id);
        return new ApiResponse("Deleted!", true);
    }
}

