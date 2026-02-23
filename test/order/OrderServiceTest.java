package com.example.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService service;

    @BeforeEach
    void setup() {
        service = new OrderService();
    }

    @Test
    void shouldCalculateTotalPriceCorrectly() {
        List<Order> orders = List.of(
                new Order("O1", 100),
                new Order("O2", 200),
                new Order("O3", 300)
        );

        double total = service.calculateTotalPrice(orders);

        assertEquals(600, total);
    }

    @Test
    void shouldFilterOrdersAboveThreshold() {
        List<Order> orders = List.of(
                new Order("O1", 100),
                new Order("O2", 500),
                new Order("O3", 800)
        );

        List<Order> result = service.filterOrdersAboveThreshold(orders, 400);

        assertEquals(2, result.size());
    }

 
    @Test
    void shouldHandleEmptyOrders() {
        double total = service.calculateTotalPrice(List.of());

        assertEquals(0, total);
    }

   
    @Test
    void shouldAggregateMultipleOrders() {
        List<Order> orders = List.of(
                new Order("O1", 50),
                new Order("O2", 75),
                new Order("O3", 25)
        );

        assertEquals(150, service.calculateTotalPrice(orders));
    }

    @Test
    void shouldThrowExceptionForNegativeOrder() {
        assertThrows(IllegalArgumentException.class,
                () -> new Order("O1", -10));
    }
}