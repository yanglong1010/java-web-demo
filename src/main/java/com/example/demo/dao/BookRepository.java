package com.example.demo.dao;

import com.example.demo.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(value = "SELECT new com.example.demo.Book(b.id, b.name, b.pageCount) FROM Book b")
    List<Book> findAllBooks();

    @Query(value = "SELECT new com.example.demo.Book(b.id, b.name, b.pageCount) FROM Book b WHERE b.name = :name")
    Book findBookByName(@Param("name") String name);

    @Query(value = "SELECT sum(b.pageCount) FROM Book b")
    Long countBookPages();
}