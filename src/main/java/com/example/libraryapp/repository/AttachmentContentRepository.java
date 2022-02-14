package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Address;
import com.example.libraryapp.entity.Attachment;
import com.example.libraryapp.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository
        extends JpaRepository<AttachmentContent, UUID> {

    Optional<AttachmentContent> findByAttachment(Attachment attachment);

}
