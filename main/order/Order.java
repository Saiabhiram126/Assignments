package com.example.order;

public class Order {

    private final String id;
    private final double price;

    public Order(String id, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Order price cannot be negative");
        }
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}