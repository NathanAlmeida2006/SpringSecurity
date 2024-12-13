package dev.nathan.security.models.product;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductFactory {

    public Product createProductWithId(UUID id, String name, String description, Double price, Long quantity) {
        return createProduct(id, name, description, price, quantity);
    }

    public Product createProductWithoutId(String name, String description, Double price, Long quantity) {
        return createProduct(null, name, description, price, quantity);
    }

    private Product createProduct(UUID id, String name, String description, Double price, Long quantity) {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
