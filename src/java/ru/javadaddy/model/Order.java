package ru.javadaddy.model;

import java.util.List;

public interface Order {
    void addItem(MenuItem item);

    List<MenuItem> getItems();

    double getTotalPrice();
}
