package com.example.libraryapp.service;

import com.example.libraryapp.component.Config;
import com.example.libraryapp.dto.ApiResponse;
import com.example.libraryapp.entity.Attachment;
import com.example.libraryapp.entity.AttachmentContent;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.repository.AttachmentContentRepository;
import com.example.libraryapp.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    //autowired bilan static farqi

    final AttachmentRepository attachmentRepository;
    final AttachmentContentRepository attachmentContentRepository;

    public ApiResponse upload(MultipartHttpServletRequest request) {
        //faqat nomlari
        Iterator<String> fileNames = request.getFileNames();
        //realniy fayllar

        while (fileNames.hasNext()) {
            List<MultipartFile> files = request.getFiles(fileNames.next());
            for (MultipartFile file : files) {
                Attachment attachment = new Attachment(
                        file.getOriginalFilename(),
                        file.getSize(),
                        file.getContentType());

                Attachment save = attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setAttachment(save);
                try {
                    attachmentContent.setBytes(file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                attachmentContentRepository.save(attachmentContent);
            }
        }
        return new ApiResponse("Mana", true);
    }


    public HttpEntity<?> download(Integer id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        Attachment attachment = byId.get();
        Optional<AttachmentContent> byAttachment = attachmentContentRepository.findByAttachment(attachment);
        AttachmentContent attachmentContent = byAttachment.get();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file")
                .body(attachmentContent.getBytes());
    }

    @SneakyThrows
    public ApiResponse uploadFileSystem(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()) {
            List<MultipartFile> files = request.getFiles(fileNames.next());
            if (files.size() > 0) {
                for (MultipartFile file : files) {
                    Attachment attachment = new Attachment(
                            file.getOriginalFilename(),
                            file.getSize(),
                            file.getContentType()
                    );
                    Attachment save = attachmentRepository.save(attachment);
                    //menyu.jpg
                    File upload = new File("src/main/resources/files/" + save.getName());
                    FileOutputStream outputStream = new FileOutputStream(upload);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                }
            }
        }
        return new ApiResponse("Zor", true);
    }


//    @SneakyThrows
//    public void getFile(Integer id, HttpServletResponse response) {
//        Optional<Attachment> byId = attachmentRepository.findById(id);
//        Attachment attachment = byId.get();
//
//        response.setHeader("Content-Disposition", attachment.getName());
//        response.setContentType(attachment.getType());
//        FileInputStream inputStream = new FileInputStream("src/main/resources/files/" + attachment.getName());
//        FileCopyUtils.copy(inputStream, response.getOutputStream());
//    }

    private Config config;

    @Autowired
    public void setConfig(Config config) {
        this.config = config;
    }

    //sanjar version
    @SneakyThrows
    public HttpEntity<?> getFile(Integer id) {


        Optional<Attachment> byId = attachmentRepository.findById(id);
        Attachment attachment = byId.get();

        FileInputStream inputStream = new FileInputStream("src/main/resources/files/" + attachment.getName());
        File file = new File("src/main/resources/files/" + attachment.getName());
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file")
                .body(inputStream.readAllBytes());
    }
}
