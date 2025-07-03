package ru.javadaddy.service;

import ru.javadaddy.model.MenuItem;
import ru.javadaddy.model.Order;
import ru.javadaddy.model.OrderImpl;

import java.util.List;

public class OrderService {

    private final Order order = new OrderImpl();

    public void addItem(MenuItem item) {
        order.addItem(item);
    }

    public List<MenuItem> findItems() {
        return order.getItems();
    }

    public double calculateTotalPrice() {
       return order.getTotalPrice();
    }
}
