package com.codecool.servlet;

import java.util.HashSet;
import java.util.Set;

public class Stock {

    Set<Item> stockSet;

    public static Item item1 = new Item("Asus Laptop", 1600);
    public static Item item2 = new Item("Harry Potter Ebook", 50);
    public static Item item3 = new Item("Lego Set", 80);

    public Stock() {
        this.stockSet = new HashSet<Item>();

        this.stockSet.add(item1);
        this.stockSet.add(item2);
        this.stockSet.add(item3);

    }

}
