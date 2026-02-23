package com.example.cart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testAddItemIncreasesTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 50);
        assertEquals(50, cart.getTotalPrice());

        cart.addItem("Banana", 30);
        assertEquals(80, cart.getTotalPrice());
    }

    @Test
    void testRemoveItemDecreasesTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 50);
        cart.addItem("Banana", 30);

        cart.removeItem("Apple");
        assertEquals(30, cart.getTotalPrice());
    }

    @Test
    void testRemoveNonExistentItemThrowsException() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 50);

        assertThrows(IllegalArgumentException.class,
                () -> cart.removeItem("Orange"));
    }

    @Test
    void testCartWithMultipleItemsHandlesCorrectly() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 50);
        cart.addItem("Banana", 30);
        cart.addItem("Mango", 100);

        assertEquals(180, cart.getTotalPrice());
    }

    @Test
    void testEmptyCartReturnsZeroTotal() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getTotalPrice());
    }
}