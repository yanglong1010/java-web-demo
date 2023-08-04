package com.example.demo;

import com.example.demo.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataUtil {
    private BookRepository bookRepo;
    private static boolean IS_PREPARED = false;

    public void prepareBooksIfNeeded(int n) {
        synchronized (DataUtil.class) {
            if (!IS_PREPARED) {
                insertBooks(n);
                IS_PREPARED = true;
                System.out.println("books prepared");
            }
        }
    }

    public void prepareBooksIfNeeded() {
        prepareBooksIfNeeded(1000 * 100);
    }

    private void insertBooks(int n) {
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Book book = new Book("Book" + i, 100 + r.nextInt(1000));
            books.add(book);
        }
        bookRepo.saveAll(books);
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
}
