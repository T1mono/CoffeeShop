package ru.javadaddy.model;

import ru.javadaddy.enums.PromoCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderImpl implements Order {

    private List<MenuItem> items = new ArrayList<>();
    private PromoCode appliedPromocode;

    /**
     * Добавить товар
     *
     * @param item
     */
    @Override
    public void addItem(MenuItem item) {

        if (item == null) {
            throw new IllegalArgumentException("Товар в заказе не может быть null");
        }

        if (!items.contains(item)) {
            items.add(item);
        }
    }

    /**
     * Получить список заказа
     *
     * @return
     */
    @Override
    public List<MenuItem> getItems() {

        if (items == null || items.isEmpty()) {
            return Collections.emptyList();
        }

        return new ArrayList<>(items);
    }

    /**
     * Рассчет стоимости с учетом скидки
     * @return
     */
    @Override
    public double getTotalPrice() {
        double subtotal = items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();

        if (appliedPromocode != null) {
            subtotal = Math.max(0, subtotal - appliedPromocode.getDiscountValue());
        }
        return subtotal;
    }
}