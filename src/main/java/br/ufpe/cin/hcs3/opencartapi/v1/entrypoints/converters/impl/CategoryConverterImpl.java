package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.impl;

import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.Category;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.IConverter;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverterImpl implements IConverter<Category, CategoryDTO>{
    @Override
    public CategoryDTO toDTO(Category entity) {
        return CategoryDTO.builder()
                          .description(entity.getDescription())
                          .id(entity.getId())
                          .build();
    }

    @Override
    public Category toEntity(CategoryDTO dto) {
        return Category.builder()
                       .description(dto.getDescription())
                       .build();
    }
}
