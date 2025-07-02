package ru.javadaddy.model;

public class Food implements MenuItem {

    private String name;

    private double price;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
