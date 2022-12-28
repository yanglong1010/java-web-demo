package com.example.demo;

public class Book2 {
    private String name;
    private int pageCount;
    private byte[] content;

    public Book2(String name, int pageCount, byte[] content) {
        this.name = name;
        this.pageCount = pageCount;
        this.content = content;
    }

    public Book2(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
