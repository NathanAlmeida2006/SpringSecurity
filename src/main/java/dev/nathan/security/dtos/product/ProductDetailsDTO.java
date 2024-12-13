package dev.nathan.security.dtos.product;

import java.util.UUID;

public record ProductDetailsDTO(UUID id, String name, String description, Double price, Long quantity) {
}
