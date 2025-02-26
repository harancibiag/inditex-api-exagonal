package es.inditex.inditextapi.infraestructure.adapter.mapper;

import es.inditex.inditextapi.domain.model.Brand;
import es.inditex.inditextapi.infraestructure.adapter.entity.BrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandDboMapper {
    BrandDboMapper INSTANCE = Mappers.getMapper(BrandDboMapper.class);

    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "brandName", target = "brandName")
    BrandEntity toDBO(Brand domain);

    @InheritInverseConfiguration
    Brand toDomain(BrandEntity entity);
}