package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int pageCount;

    public Book(Long id, String name, int pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
