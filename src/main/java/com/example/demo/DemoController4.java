package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController4 {
    @GetMapping("/queryBooksByPage")
    public ResultData<List<Book2>> index(@RequestParam int page, int pageSize) {
        long start = System.currentTimeMillis();
        List<Book2> allBooks = queryAllBooks();
        List<Book2> list = getBooksByPage(allBooks, page, pageSize);
        return new ResultData<>(list, System.currentTimeMillis() - start);
    }

    private List<Book2> queryAllBooks() {
        List<Book2> list = new ArrayList<>();
        for (int i = 0; i < 1024 * 20; i++) {
            list.add(new Book2("Book" + i, new byte[1024 * 256]));
        }
        return list;
    }

    private List<Book2> getBooksByPage(List<Book2> allBooks, int page, int pageSize) {
        if (allBooks == null || allBooks.isEmpty()) {
            return null;
        }

        int fromIndex = (page - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        return allBooks.subList(fromIndex, toIndex);
    }
}