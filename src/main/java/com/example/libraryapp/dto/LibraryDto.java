package com.example.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LibraryDto {
    private String name;
    private String city;
    private String home;
    private String street;
}