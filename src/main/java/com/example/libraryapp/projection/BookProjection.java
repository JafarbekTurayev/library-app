package com.example.libraryapp.projection;


import com.example.libraryapp.entity.Book;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@Projection(name = "ketmon", types = Book.class)
public interface BookProjection {
    String getName();

    @Value("#{target.library.name}")
    String getLibraryName();

    //    @JsonSerialize
    @Value("#{target.categoryList[0].name}")
    String getCategoryNames();
}
