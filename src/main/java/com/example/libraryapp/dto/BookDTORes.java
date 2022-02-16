package com.example.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTORes {

    private String name;
    //    private List<String> categoryName;
    private String libraryName;

}
