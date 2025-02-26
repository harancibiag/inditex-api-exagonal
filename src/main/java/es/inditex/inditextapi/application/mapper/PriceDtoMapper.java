package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.PriceDTO;
import es.inditex.inditextapi.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {
    PriceDtoMapper INSTANCE = Mappers.getMapper(PriceDtoMapper.class);

    PriceDTO toDTO(Price domain);
}
