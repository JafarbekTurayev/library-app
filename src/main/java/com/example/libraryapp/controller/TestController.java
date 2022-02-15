package com.example.libraryapp.controller;

import com.example.libraryapp.component.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    Test test;

    @GetMapping("/request")
    public String getPage() {
        return test.getRequestScope().getName() + test.getRequestScope().hashCode();
    }

    @GetMapping("/session")
    public String getSession() {
        return test.getSessionScope().getName() + test.getSessionScope().hashCode();
    }

}
