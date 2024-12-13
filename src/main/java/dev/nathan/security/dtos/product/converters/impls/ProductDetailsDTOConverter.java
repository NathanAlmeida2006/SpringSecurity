package dev.nathan.security.dtos.product.converters.impls;

import dev.nathan.security.dtos.product.converters.ProductConverter;
import dev.nathan.security.dtos.product.ProductDetailsDTO;
import dev.nathan.security.models.product.Product;
import dev.nathan.security.models.product.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsDTOConverter implements ProductConverter<ProductDetailsDTO> {

    private final ProductFactory productFactory;

    public ProductDetailsDTOConverter(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public Product toEntity(ProductDetailsDTO dto) {
        return productFactory.createProductWithId(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    @Override
    public ProductDetailsDTO toDto(Product product) {
        return new ProductDetailsDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
