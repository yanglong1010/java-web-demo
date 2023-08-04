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
public class DemoController {
    private BookRepository bookRepo;
    private DataUtil dataUtil;

    @GetMapping("/countBookPages")
    public ResultData<Long> index() {
        long start = System.currentTimeMillis();
        dataUtil.prepareBooksIfNeeded();

        List<Book> list = queryBooks();
        long pageCount = countBookPages(list);

        return new ResultData<>(pageCount, System.currentTimeMillis() - start);
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
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getPageCount();
        }
        return count;
    }

    @Autowired
    public void setDataUtil(DataUtil dataUtil) {
        this.dataUtil = dataUtil;
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
}