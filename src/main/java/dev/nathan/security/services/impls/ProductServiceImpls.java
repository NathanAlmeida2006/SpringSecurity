package dev.nathan.security.services.impls;

import dev.nathan.security.dtos.product.converters.impls.ProductDTOConverter;
import dev.nathan.security.dtos.product.converters.impls.ProductDetailsDTOConverter;
import dev.nathan.security.dtos.product.converters.impls.ProductFormDTOConverter;
import dev.nathan.security.dtos.product.ProductDTO;
import dev.nathan.security.dtos.product.ProductDetailsDTO;
import dev.nathan.security.dtos.product.ProductFormDTO;
import dev.nathan.security.dtos.product.UpdateProductFormDTO;
import dev.nathan.security.models.product.Product;
import dev.nathan.security.repositories.ProductRepository;
import dev.nathan.security.services.interfaces.ProductService;
import dev.nathan.security.services.updaters.ProductUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpls implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDTOConverter productDtoConverter;
    private final ProductDetailsDTOConverter productDetailsDtoConverter;
    private final ProductFormDTOConverter productFormDtoConverter;
    private final ProductUpdater productUpdater;

    @Override
    public ProductDTO createProduct(ProductFormDTO productFormDTO) {
        Product product = productFormDtoConverter.toEntity(productFormDTO);
        productRepository.save(product);
        return productDtoConverter.toDto(product);
    }

    @Override
    public List<ProductDetailsDTO> listProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productDetailsDtoConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDetailsDTO findById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        return productDetailsDtoConverter.toDto(product);
    }

    @Override
    public ProductDTO updateProduct(UUID id, UpdateProductFormDTO updateProductFormDTO) {
        Product product = productRepository.findById(id).orElse(null);
        productUpdater.updateProduct(product, updateProductFormDTO);
        productRepository.save(product);
        return productDtoConverter.toDto(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);
    }
}
