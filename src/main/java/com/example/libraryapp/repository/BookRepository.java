package com.example.libraryapp.repository;

import com.example.libraryapp.dto.BookDTO;
import com.example.libraryapp.dto.BookDTORes;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Category;
import com.example.libraryapp.projection.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository
        extends JpaRepository<Book, Integer> {

    //kutubxona tegishli kitoblar
//    List<BookProjection> findAllByLibrary_Id(Integer id);

//    List<Book> findAllByNameContainsAndLibrary_IdAndCategoryList

    List<Book> findAllByName(String name);

    //search
//    List<Book> findAllByNameContains(String name);
    List<Book> findAllByNameContainingIgnoreCase(String name);
//    List<BookProjection> findAllByNameContains(String name);

//    @Query(value = "select b from book b  where b.library_id=?1")
//    List<BookDTORes> getAllByLibraryId(@Param("id") Integer id);

    //jpql
//    @Query("select b from Book b where b.library.name like ?1%")
//    List<Book> getBooksByCategoryList(String name);


//    List<Book> findAllByCategoryListIn(List<Integer> ids);

}
