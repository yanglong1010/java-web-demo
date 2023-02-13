package com.example.demo;

import java.io.Serializable;

public class Book2 implements Serializable {
    private String name;
    private byte[] content;

    public Book2(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public Book2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
