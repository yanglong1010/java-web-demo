package com.example.demo;

import com.example.demo.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class DemoController6 {
    private BookRepository bookRepo;
    private DataUtil dataUtil;
    private static List<Book> list = null;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    @GetMapping("/groupBook2")
    public ResultData<Map<Integer, Integer>> index() throws InterruptedException {
        long start = System.currentTimeMillis();
        dataUtil.prepareBooksIfNeeded(1000 * 1000);
        synchronized (this) {
            if (list == null) {
                list = bookRepo.findAllBooks();
            }
        }

        Map<Integer, Integer> map = groupByPage(list);
        return new ResultData<>(map, System.currentTimeMillis() - start);
    }

    private Map<Integer, Integer> groupByPage(List<Book> list) throws InterruptedException {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        int part = 1000;
        int n = list.size() / part;
        int m = list.size() % part == 0 ? n : n + 1;
        CountDownLatch latch = new CountDownLatch(m);
        for (int i = 0; i < m; i++) {
            int index = i * part;
            List<Book> subList = list.subList(index, index + part);
            executorService.submit(() -> {
                groupBook(map, subList);
                latch.countDown();
            });
        }
        latch.await();
        return map;
    }

    private static void groupBook(Map<Integer, Integer> map, List<Book> subList) {
        for (Book book : subList) {
            int key = book.getPageCount() / 10 * 10;
            map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
        }
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