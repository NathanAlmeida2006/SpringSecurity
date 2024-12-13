package dev.nathan.security.services.interfaces;

import dev.nathan.security.dtos.product.ProductDTO;
import dev.nathan.security.dtos.product.ProductDetailsDTO;
import dev.nathan.security.dtos.product.ProductFormDTO;
import dev.nathan.security.dtos.product.UpdateProductFormDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDTO createProduct(ProductFormDTO productFormDTO);

    List<ProductDetailsDTO> listProducts();

    ProductDetailsDTO findById(UUID id);

    ProductDTO updateProduct(UUID id, UpdateProductFormDTO updateProductFormDTO);

    void deleteProduct(UUID id);
}
