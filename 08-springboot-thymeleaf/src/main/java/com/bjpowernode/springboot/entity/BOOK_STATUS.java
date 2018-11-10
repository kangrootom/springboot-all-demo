package com.bjpowernode.springboot.entity;

public enum BOOK_STATUS {
    SOLD("1"),UNSOLD("0");

    private String name;
    BOOK_STATUS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
