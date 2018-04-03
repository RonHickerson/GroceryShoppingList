package com.company;

import java.time.LocalDateTime;
import java.util.Objects;

public class GroceryItem {
    private String name;
    private int price;
    private LocalDateTime date;

    public GroceryItem(String name, int price, LocalDateTime date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroceryItem that = (GroceryItem) o;
        return price == that.price &&
                date == that.date &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price, date);
    }

    @Override
    public String toString() {
        return date + "|" + name + "|" + price;
    }
}

