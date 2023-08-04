package com.example.demo;

import com.example.demo.dao.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController3.class);
    private BookRepository bookRepo;

    @GetMapping("/queryBook")
    public ResultData<Book> index(@RequestParam String name) {
        long start = System.currentTimeMillis();

        Book book = queryBookByName(name);

        recordPV();

        return new ResultData<>(book, System.currentTimeMillis() - start);
    }

    private Book queryBookByName(String name) {
        return bookRepo.findBookByName(name);
    }

    private void recordPV() {
        String url = System.getenv("PV_URL");
        System.out.println(url);
        try {
            Thread.sleep(2000);
            HTTPUtil.sendRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/pv")
    public ResultData<Long> index() {
        long start = System.currentTimeMillis();
        long pv = PV.addAndGet(1);
        System.out.println("current pv:" + pv);
        return new ResultData<>(pv, System.currentTimeMillis() - start);
    }
    private static final AtomicLong PV = new AtomicLong(0);
}