package es.inditex.inditextapi.infraestructure.adapter.mapper;


import es.inditex.inditextapi.domain.model.Price;
import es.inditex.inditextapi.infraestructure.adapter.entity.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceDboMapper {
    PriceDboMapper INSTANCE = Mappers.getMapper(PriceDboMapper.class);

    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "priceAmount", target = "priceAmount")
    @Mapping(source = "curr", target = "curr")
    PriceEntity toDBO(Price domain);

    @InheritInverseConfiguration
    Price toDomain(PriceEntity entity);

}
