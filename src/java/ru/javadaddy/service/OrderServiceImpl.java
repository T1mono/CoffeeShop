package ru.javadaddy.service;

import ru.javadaddy.model.MenuItem;
import ru.javadaddy.model.Order;
import ru.javadaddy.model.OrderImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final Order order = new OrderImpl();

    @Override
    public void addItem(MenuItem item) {
        order.addItem(item);
    }

    @Override
    public List<MenuItem> findItems() {
        return order.getItems();
    }

    @Override
    public double calculateTotalPrice() {
       return order.getTotalPrice();
    }
}
