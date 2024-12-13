package dev.nathan.security.dtos.product.converters.impls;

import dev.nathan.security.dtos.product.converters.ProductConverter;
import dev.nathan.security.dtos.product.ProductDTO;
import dev.nathan.security.models.product.Product;
import dev.nathan.security.models.product.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOConverter implements ProductConverter<ProductDTO> {

    private final ProductFactory productFactory;

    public ProductDTOConverter(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        return productFactory.createProductWithId(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    @Override
    public ProductDTO toDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
