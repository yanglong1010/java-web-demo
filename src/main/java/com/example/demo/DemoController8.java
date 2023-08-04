package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController8 {
    private static final List<byte[]> list = new ArrayList<>();

    @GetMapping("/memLeak2")
    public void index() {
        doWork();
    }

    private void doWork() {
        Random r = new Random();
        list.add(new byte[r.nextInt(1024) + 1024]);
    }
}