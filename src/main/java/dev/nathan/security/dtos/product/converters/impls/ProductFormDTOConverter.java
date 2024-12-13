package dev.nathan.security.dtos.product.converters.impls;

import dev.nathan.security.dtos.product.converters.ProductConverter;
import dev.nathan.security.dtos.product.ProductFormDTO;
import dev.nathan.security.models.product.Product;
import dev.nathan.security.models.product.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFormDTOConverter implements ProductConverter<ProductFormDTO> {

    private final ProductFactory productFactory;

    public ProductFormDTOConverter(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public Product toEntity(ProductFormDTO dto) {
        return productFactory.createProductWithoutId(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    @Override
    public ProductFormDTO toDto(Product product) {
        throw new UnsupportedOperationException("Conversion from Product to ProductFormDTO is not supported");
    }
}
