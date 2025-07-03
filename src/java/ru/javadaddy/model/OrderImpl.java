package ru.javadaddy.model;

import java.util.List;

public class OrderImpl implements Order {

    private List<MenuItem> items;

    @Override
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public List<MenuItem> getItems() {
        return this.items;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}