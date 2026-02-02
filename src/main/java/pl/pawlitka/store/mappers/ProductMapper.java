package pl.pawlitka.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawlitka.store.dtos.ProductDto;
import pl.pawlitka.store.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
