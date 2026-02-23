package com.example.order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    
    public double calculateTotalPrice(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return 0;
        }

        return orders.stream()
                .mapToDouble(Order::getPrice)
                .sum();
    }

    public List<Order> filterOrdersAboveThreshold(List<Order> orders, double threshold) {
        if (orders == null || orders.isEmpty()) {
            return List.of();
        }

        return orders.stream()
                .filter(o -> o.getPrice() > threshold)
                .collect(Collectors.toList());
    }
}