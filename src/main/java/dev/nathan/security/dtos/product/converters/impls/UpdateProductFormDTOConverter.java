package dev.nathan.security.dtos.product.converters.impls;

import dev.nathan.security.dtos.product.converters.ProductConverter;
import dev.nathan.security.dtos.product.UpdateProductFormDTO;
import dev.nathan.security.models.product.Product;
import dev.nathan.security.models.product.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductFormDTOConverter implements ProductConverter<UpdateProductFormDTO> {

    private final ProductFactory productFactory;

    public UpdateProductFormDTOConverter(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public Product toEntity(UpdateProductFormDTO dto) {
        return productFactory.createProductWithoutId(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    @Override
    public UpdateProductFormDTO toDto(Product product) {
        throw new UnsupportedOperationException("Conversion from Product to UpdateProductFormDTO is not supported");
    }
}
