package com.example.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartMockitoTest {

    @Mock
    private DiscountService discountService;

    private ShoppingCartMockito cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCartMockito(discountService);
    }

    
    @Test
    void testTenPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(10.0);

        cart.addItem("Book", 100);
        double total = cart.getTotalPrice();

        assertEquals(90.0, total);
    }

 
    @Test
    void testZeroPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(0.0);

        cart.addItem("Pen", 50);
        double total = cart.getTotalPrice();

        assertEquals(50.0, total);
    }

  
    @Test
    void testFiftyPercentDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(50.0);

        cart.addItem("Shoes", 200);
        double total = cart.getTotalPrice();

        assertEquals(100.0, total);
    }


    @Test
    void testDiscountCalledOnce() {
        when(discountService.getDiscountPercentage()).thenReturn(10.0);

        cart.addItem("Bag", 100);
        cart.getTotalPrice();

        verify(discountService, times(1)).getDiscountPercentage();
    }

    @Test
    void testMultipleItemsWithDiscount() {
        when(discountService.getDiscountPercentage()).thenReturn(20.0);

        cart.addItem("Item1", 100);
        cart.addItem("Item2", 200);

        double total = cart.getTotalPrice();

        assertEquals(240.0, total); // 300 - 20%
    }
}