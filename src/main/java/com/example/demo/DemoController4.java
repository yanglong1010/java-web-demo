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
public class DemoController4 {
    private BookRepository bookRepo;
    private DataUtil dataUtil;

    @GetMapping("/countBookPages3")
    public ResultData<Long> index() {
        long start = System.currentTimeMillis();

        dataUtil.prepareBooksIfNeeded();

        long pageCount = bookRepo.countBookPages();

        return new ResultData<>(pageCount, System.currentTimeMillis() - start);
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Autowired
    public void setDataUtil(DataUtil dataUtil) {
        this.dataUtil = dataUtil;
    }
}