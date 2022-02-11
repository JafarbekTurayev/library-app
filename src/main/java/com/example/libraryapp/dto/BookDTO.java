package com.example.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private String name;
    private List<Integer> categoryIds;
    private Integer libraryId;
}
