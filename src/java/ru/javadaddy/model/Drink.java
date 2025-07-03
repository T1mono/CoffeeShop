package ru.javadaddy.model;

import java.util.Objects;
import java.util.Optional;

public class Drink implements MenuItem {

    private String name;

   private double price;

   private double volume;

    public Drink(String name, double price, double volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.volume;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Double.compare(price, drink.price) == 0 && Double.compare(volume, drink.volume) == 0 && Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, volume);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}
