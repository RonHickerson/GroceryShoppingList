package com.company;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        // Create 3 Grocery Items
        GroceryItem eggs = new GroceryItem("Eggs", 3, LocalDateTime.now());
        GroceryItem milk = new GroceryItem("Milk", 3, LocalDateTime.now());
        GroceryItem bread = new GroceryItem("Bread", 3, LocalDateTime.now());


    }
}
