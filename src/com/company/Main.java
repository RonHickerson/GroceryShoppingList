package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");
        LocalDateTime today = LocalDateTime.now();



        // Create 3 Grocery Items
        GroceryItem eggs = new GroceryItem("Eggs", 3, today);
        GroceryItem milk = new GroceryItem("Milk", 4, today);
        GroceryItem bread = new GroceryItem("Bread", 2, today);
        System.out.println("\tGrocery List: \n" + eggs + "\n" + milk + "\n" + bread);



        // Store Items in ArrayList
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(eggs);
        groceryList.add(milk);
        groceryList.add(bread);

        GroceryItem porkchops = new GroceryItem("Porkchop", 12, LocalDateTime.of(2018, 4, 2, 11,46,0));
        groceryList.add(porkchops);
        LocalDateTime lastVisit = lastVisit(groceryList, today);

        // Items from last visit
        int itemsFromLastVisit = countGroceriesFromDate(groceryList, lastVisit);
        System.out.println("Items bought on " + lastVisit + ": " + itemsFromLastVisit);

        // Price of items from last visit
        int pricesFromLastVisit = calculatePriceOfItemsFromDate(groceryList, lastVisit);
        System.out.println("Total amount spent on " + lastVisit + ": " + pricesFromLastVisit);

        // Number of items purchased by names
        int numberOfItemsPurchased = countItemPurchased(groceryList, "Eggs");
        System.out.println("Number of eggs purchased: " + numberOfItemsPurchased);

        // Items that cost more $10
        ArrayList<String> itemsMoreThan10Dollars = itemsHigherThanPrice(groceryList, 10);
        System.out.println("Items that cost more than $10: " + itemsMoreThan10Dollars);

        //  The next time you go grocery shopping, you want to buy all items purchased on each of the last [X] days but
        // only [Y] items that costs more than $[Z]. For example, if X is 2, Y is 3, and Z is $10; then your shopping
        // list should have all items that were purchased during the last 2 shopping dates but remove all but 3 items
        // that cost more than $10 from that list.

        //

         ArrayList<String> nextTime = futureList(groceryList, today, 2, 3, 10);
        System.out.println("Things to buy later: " + nextTime);

    }




     private static ArrayList<String> futureList(ArrayList<GroceryItem> list, LocalDateTime date, int days, int items, int price) {
        int count = 0;
        ArrayList<String> futurePurchases = new ArrayList<>();

        for (int i = 0; i < list.size() ; i++) {
            if (count > items)
                break;
             else if (list.get(i).getDate().minusDays(days).isBefore(date) && list.get(i).getPrice() > price) {
                futurePurchases.add(list.get(i).getName());
                count++;
            }
         }
         return futurePurchases;
     }

    // Match List based on dates
    public static ArrayList<GroceryItem> matchListDate(ArrayList<GroceryItem> list, LocalDateTime date){
        ArrayList<GroceryItem> matchList= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDate() == date)
                matchList.add(list.get(i));
        }
        return matchList;
    }

    // Match List based on names
    public static ArrayList<GroceryItem> matchListName(ArrayList<GroceryItem> list, String name){
        ArrayList<GroceryItem> matchList= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == name)
                matchList.add(list.get(i));
        }
        return matchList;
    }

    // Match List based on Price
    public static ArrayList<GroceryItem> greaterThanListPrice(ArrayList<GroceryItem> list, int price){
        ArrayList<GroceryItem> matchList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > price)
                matchList.add(list.get(i));
        }
        return matchList;
    }

    // LastVisit
    public static LocalDateTime lastVisit(ArrayList<GroceryItem> list, LocalDateTime date){
        LocalDateTime minDate= list.get(0).getDate();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDate().isBefore(date))
                minDate = list.get(i).getDate();
        }
       return minDate;
    }

    // How many items were bought during the last visit to the store
    public static int countGroceriesFromDate(ArrayList<GroceryItem> list, LocalDateTime date) {
       ArrayList<GroceryItem> count = matchListDate(list, date);
        return count.size();
    }

    // Total price of items purchased on date
    public static int calculatePriceOfItemsFromDate (ArrayList<GroceryItem> list, LocalDateTime date) {
        int totalPrice = 0;
        ArrayList<GroceryItem> prices = matchListDate(list, date);
        for (int i = 0; i < prices.size() ; i++){
            totalPrice = totalPrice + prices.get(i).getPrice();
        }
        return totalPrice;
    }

    // How many of a specific item was purchased
    public static int countItemPurchased(ArrayList<GroceryItem> list, String name) {
        ArrayList<GroceryItem> names = matchListName(list, name);
        return names.size();
    }

    // What items were purchased that cost more than price
    public static ArrayList<String> itemsHigherThanPrice(ArrayList<GroceryItem> list, int price) {
        ArrayList<String> itemList = new ArrayList<>();
        ArrayList<GroceryItem> itemMoreThanPrice = greaterThanListPrice(list, price);
        for (int i = 0; i < itemMoreThanPrice.size(); i++) {
            itemList.add(itemMoreThanPrice.get(i).getName());
        }
       return itemList;
    }
}
