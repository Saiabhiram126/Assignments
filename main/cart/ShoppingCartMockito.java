package com.example.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCartMockito {

    private final Map<String, Double> items = new HashMap<>();
    private final DiscountService discountService;

    // Constructor injection for Mockito
    public ShoppingCartMockito(DiscountService discountService) {
        this.discountService = Objects.requireNonNull(
                discountService,
                "DiscountService cannot be null"
        );
    }

    public void addItem(String item, double price) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Invalid item name");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        items.put(item, price);
    }

    public void removeItem(String item) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in cart");
        }
        items.remove(item);
    }

    public double getTotalPrice() {
        double sum = items.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        double discount = discountService.getDiscountPercentage();
        return sum * (1 - discount / 100.0);
    }
}