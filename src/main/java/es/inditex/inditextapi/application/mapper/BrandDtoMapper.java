package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.BrandDTO;
import es.inditex.inditextapi.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandDtoMapper {
    BrandDtoMapper INSTANCE = Mappers.getMapper(BrandDtoMapper.class);

    BrandDTO toDTO(Brand domain);
}