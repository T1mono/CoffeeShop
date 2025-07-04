package ru.javadaddy.service;

import ru.javadaddy.model.MenuItem;

import java.util.List;

public interface OrderService {
    void addItem(MenuItem item);

    List<MenuItem> findItems();

    double calculateTotalPrice();
}
