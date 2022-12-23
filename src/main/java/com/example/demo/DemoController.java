package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController {
    @GetMapping("/countAllBookPages")
    public ResultData<Long> index() {
        long start = System.currentTimeMillis();
        List<Book> list = queryAllBooks();
        long pageCount = countAllBookPages(list);
        return new ResultData<>(pageCount, System.currentTimeMillis() - start);
    }

    private List<Book> queryAllBooks() {
        Random random = new Random();
        List<Book> list = new LinkedList<>();
        for (int i = 0; i < 1024 * 50; i++) {
            list.add(new Book("Book" + i, 200 + random.nextInt(100)));
        }
        return list;
    }

    private long countAllBookPages(List<Book> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        long count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getPageCount();
        }
        return count;
    }
}