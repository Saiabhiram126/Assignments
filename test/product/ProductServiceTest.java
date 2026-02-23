package com.example.product;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private final ProductService service = new ProductService();

    // 1. Verify 10% discount
    @Test
    void testTenPercentDiscount() {
        Product product = new Product("Item1", 100.0);

        Function<Product, Double> discount10 = p -> p.getPrice() * 0.9;
        assertEquals(90.0, service.applyDiscount(product, discount10));
    }

    // 2. Zero percent discount should return original price
    @Test
    void testZeroPercentDiscount() {
        Product product = new Product("Item2", 80.0);

        Function<Product, Double> noDiscount = p -> p.getPrice();
        assertEquals(80.0, service.applyDiscount(product, noDiscount));
    }

    // 3. Negative price behavior
    @Test
    void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Item3", -50.0));
    }

    // 4. Multiple products discounted correctly
    @Test
    void testMultipleProductsDiscounted() {
        List<Product> products = Arrays.asList(
                new Product("A", 100),
                new Product("B", 200),
                new Product("C", 300)
        );

        Function<Product, Double> disc20 = p -> p.getPrice() * 0.8;
        List<Double> discountedPrices = service.applyDiscountToAll(products, disc20);

        assertEquals(Arrays.asList(80.0, 160.0, 240.0), discountedPrices);
    }

    // 5. Discount function swap dynamically
    @Test
    void testDiscountFunctionSwappable() {
        Product product = new Product("D", 100);

        Function<Product, Double> noDiscount = p -> p.getPrice();
        Function<Product, Double> halfDiscount = p -> p.getPrice() * 0.5;

        assertEquals(100.0, service.applyDiscount(product, noDiscount));
        assertEquals(50.0, service.applyDiscount(product, halfDiscount));
    }
}