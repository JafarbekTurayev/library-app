package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Address;
import com.example.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository
        extends JpaRepository<Address, Integer> {

}
