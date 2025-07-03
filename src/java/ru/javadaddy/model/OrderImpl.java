package ru.javadaddy.model;

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

        Optional<MenuItem> menuItemStream = items.stream()
                .filter(i -> i.getName().equals(item.getName()))
                .findFirst();

        if (menuItemStream.isPresent()) {
            items.add(item);
        }

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