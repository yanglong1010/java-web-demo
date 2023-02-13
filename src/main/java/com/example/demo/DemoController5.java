package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController5 {
    @GetMapping("/queryBooksByPage2")
    public ResultData<List<Book2>> index(@RequestParam int page, int pageSize) {
        long start = System.currentTimeMillis();
        List<Book2> list = getBooksByPage(page, pageSize);
        List<Book2> resultList = new ArrayList<>();
        list.forEach(item -> resultList.add(new Book2(item.getName())));
        return new ResultData<>(resultList, System.currentTimeMillis() - start);
    }

    private List<Book2> getBooksByPage(int page, int pageSize) {
        // 这里做了简化，实际应该用分页SQL从数据库中读取
        List<Book2> list = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            list.add(new Book2("Book" + i, new byte[2014 * 256]));
        }
        return list;
    }
}