package dev.nathan.security.dtos.product;

import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, Double price, Long quantity) {
}
