package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Address;
import com.example.libraryapp.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepository
        extends JpaRepository<Attachment, Integer> {

}
