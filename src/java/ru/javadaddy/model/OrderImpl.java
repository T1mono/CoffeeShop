package ru.javadaddy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OrderImpl implements Order {

    private List<MenuItem> items;

    @Override
    public void addItem(MenuItem item) {

        if (item == null) {
            throw new IllegalArgumentException("Товар в заказе не может быть null");
        }

        if (!items.contains(item)) {
            items.add(item);
        }
    }

    @Override
    public List<MenuItem> getItems() {

        if (items == null || items.isEmpty()) {
            return Collections.emptyList();
        }

        return new ArrayList<>(items);
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