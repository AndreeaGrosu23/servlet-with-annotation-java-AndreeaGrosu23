package com.codecool.servlet;

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> list;

    public Cart() {
        this.list = new ArrayList<>();
    }

    public void add(Item product) {
        this.list.add(product);
    }

    public void remove(Item product) {
        this.list.remove(product);
    }

}
