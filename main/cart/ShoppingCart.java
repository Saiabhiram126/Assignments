package com.example.cart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, Double> items = new HashMap<>();

    public void addItem(String item, double price) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Item name is invalid");
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
        return items.values().stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }
}