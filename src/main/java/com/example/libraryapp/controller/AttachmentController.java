package com.example.libraryapp.controller;

import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/file")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    //db ga saqlash
    //upload
//    @PostMapping("/upload")
//    public ApiResponse upload(MultipartHttpServletRequest request) {
//        return attachmentService.upload(request);
//    }
//
//    //download
//    @GetMapping("/download/{id}")
//    public HttpEntity<?> download(@PathVariable Integer id) {
//        return attachmentService.download(id);
//    }


    //file system attachment
    @PostMapping("/upload/file")
    public ApiResponse upload(MultipartHttpServletRequest request) {
        return attachmentService.uploadFileSystem(request);
    }

//    @GetMapping("/download/{id}")
//    public void getFile(@PathVariable Integer id, HttpServletResponse response) {
//        attachmentService.getFile(id, response);
//    }

    @GetMapping("/download/file/{id}")
    public HttpEntity<?> getFile(@PathVariable Integer id) {
        return attachmentService.getFile(id);
    }
}
