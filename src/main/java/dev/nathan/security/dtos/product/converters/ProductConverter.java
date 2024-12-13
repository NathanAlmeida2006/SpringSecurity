package dev.nathan.security.dtos.product.converters;

import dev.nathan.security.models.product.Product;

public interface ProductConverter<T> {
    Product toEntity(T dto);

    T toDto(Product product);
}
