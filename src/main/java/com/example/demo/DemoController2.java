package com.example.demo;

import com.example.demo.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController2 {
    private BookRepository bookRepo;

    @GetMapping("/countBookPages2")
    public ResultData<Long> index() {
        long start = System.currentTimeMillis();

        List<Book> list = queryBooks();
        if (list.isEmpty()) {
            prepareBooks();
            list = queryBooks();
        }
        long pageCount = countBookPages(list);

        return new ResultData<>(pageCount, System.currentTimeMillis() - start);
    }

    private void prepareBooks() {
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        int BOOK_NUMBER = 1000 * 100;
        for (int i = 0; i < BOOK_NUMBER; i++) {
            Book book = new Book("Book" + i, 100 + r.nextInt(1000));
            books.add(book);
        }
        bookRepo.saveAll(books);
    }

    private List<Book> queryBooks() {
        List<Book> books = bookRepo.findAllBooks();
        return new LinkedList<>(books);
    }

    private long countBookPages(List<Book> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        long count = 0;
        for (Book book : list) {
            count += book.getPageCount();
        }
        return count;
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
}