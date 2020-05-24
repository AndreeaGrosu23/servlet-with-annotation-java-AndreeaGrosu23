package com.codecool.servlet;

public class Item {

    private static int count = 0;
    private int id = 0;
    private String name;
    private double price;

    public Item (String name, double price) {
        this.id = count++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price= " + price + "}";
    }

}
