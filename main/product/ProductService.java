package com.example.product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductService {

    public double applyDiscount(Product product, Function<Product, Double> discountFunction) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return discountFunction.apply(product);
    }

    public List<Double> applyDiscountToAll(List<Product> products,
                                           Function<Product, Double> discountFunction) {
        return products.stream()
                .map(discountFunction)
                .collect(Collectors.toList());
    }
}