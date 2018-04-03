package com.company;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        // Create 3 Grocery Items
        GroceryItem eggs = new GroceryItem("Eggs", 3, LocalDateTime.now());
        GroceryItem milk = new GroceryItem("Milk", 4, LocalDateTime.now());
        GroceryItem bread = new GroceryItem("Bread", 2, LocalDateTime.now());
        System.out.println("\tGrocery List: \n" + eggs + "\n" + milk + "\n" + bread);

        // Store Items in ArrayList
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(eggs);
        groceryList.add(milk);
        groceryList.add(bread);


    }
}
