package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibraryRepository
        extends JpaRepository<Library, Integer> {

    List<Library> findAllByNameContainsOrAddress_CityContains(String name, String city);

//    @Query(value = "select * from library where id=:ketmon_id and name like :ketmon", nativeQuery = true)
//    List<Library> getAllLib(@Param("ketmon_id") Integer id, @Param("ketmon_name") String name);

}
