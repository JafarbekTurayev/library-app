package com.example.libraryapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    //ishladi
//    private UUID code = UUID.randomUUID();

//generatsiya 13 xonali
//    private long code = new RandomDataGenerator().nextLong(1000000000000L, 10000000000000L);


    @CreationTimestamp
    private Timestamp createdAt;

    public Category(String name) {
        this.name = name;
    }
}
