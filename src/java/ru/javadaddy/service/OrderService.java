package ru.javadaddy.service;

import ru.javadaddy.model.MenuItem;
import ru.javadaddy.model.Order;
import ru.javadaddy.model.OrderImpl;

public class OrderService {

    private final Order orderRepository = new OrderImpl();


    //TODO: Добавление товара в заказ
    public void addItem (MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalArgumentException("Товар не может быть null");
        }


    }
}
