package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {


    List<Category> findAllByNameContaining(String name);

//    @Override
//    Page<Category> findAll(Pageable pageable);


//    Page<Category> findAllByCreatedAtBetween(Timestamp begin, Timestamp end);

    Slice<Category> findAllByCreatedAtBetween(Pageable pageable, Timestamp begin, Timestamp end);


//    Pageable page bet 0 1 2  size 10 20 5 2

//    @Override
//    Page<Category> findAll(Pageable pageable, Sort sort);


    //jpql
//    @Query("select c from Category c where c.id=?1")
//    Optional<Category> getOneByIdJpql(Integer id);


    //native
//    @Query(value = "select * from category where id=:id", nativeQuery = true)
//    Optional<Category> getOneByIdNative(Integer id); //@Param("id")

    //jpa
//    Optional<Category> findById(Integer id);
}
