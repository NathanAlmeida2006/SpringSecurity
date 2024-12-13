package dev.nathan.security.services.updaters;

import dev.nathan.security.dtos.product.UpdateProductFormDTO;
import dev.nathan.security.models.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUpdater {
    public void updateProduct(Product product, UpdateProductFormDTO updateProductFormDTO) {
        if (updateProductFormDTO.name() != null && !updateProductFormDTO.name().equals(product.getName())) {
            product.setName(updateProductFormDTO.name());
        }
        if (updateProductFormDTO.description() != null && !updateProductFormDTO.description().equals(product.getDescription())) {
            product.setDescription(updateProductFormDTO.description());
        }
        if (updateProductFormDTO.price() != null && !updateProductFormDTO.price().equals(product.getPrice())) {
            product.setPrice(updateProductFormDTO.price());
        }
        if (updateProductFormDTO.quantity() != null && !updateProductFormDTO.quantity().equals(product.getQuantity())) {
            product.setQuantity(updateProductFormDTO.quantity());
        }
    }
}