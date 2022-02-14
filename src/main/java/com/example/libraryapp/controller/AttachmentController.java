package com.example.libraryapp.controller;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/file")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    //upload
    @PostMapping("/upload")
    public ApiResponse upload(MultipartHttpServletRequest request) {
        return attachmentService.upload(request);
    }

    //download
    @GetMapping("/download/{id}")
    public HttpEntity<?> download(@PathVariable Integer id) {
        return attachmentService.download(id);
    }
    //getId



    //file system

}
