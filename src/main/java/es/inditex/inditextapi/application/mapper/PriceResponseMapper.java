package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.response.PriceResponse;
import es.inditex.inditextapi.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {
    PriceResponse toResponse(Price response);
}
