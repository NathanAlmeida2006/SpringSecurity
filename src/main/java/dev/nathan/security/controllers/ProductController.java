package dev.nathan.security.controllers;

import dev.nathan.security.dtos.product.ProductDTO;
import dev.nathan.security.dtos.product.ProductDetailsDTO;
import dev.nathan.security.dtos.product.ProductFormDTO;
import dev.nathan.security.dtos.product.UpdateProductFormDTO;
import dev.nathan.security.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductFormDTO productFormDTO) {
        ProductDTO productDTO = productService.createProduct(productFormDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDetailsDTO>> listProducts() {
        List<ProductDetailsDTO> list = productService.listProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsDTO> findById(@PathVariable UUID id) {
        ProductDetailsDTO productDetailsDTO = productService.findById(id);
        return ResponseEntity.ok(productDetailsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID id, @RequestBody UpdateProductFormDTO updateProductFormDTO) {
        ProductDTO productDTO = productService.updateProduct(id, updateProductFormDTO);
        return ResponseEntity.ok(productDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
