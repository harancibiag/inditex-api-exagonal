package es.inditex.inditextapi.application.usecases;

import es.inditex.inditextapi.domain.dto.request.PriceRequest;
import es.inditex.inditextapi.domain.dto.response.PriceResponse;

public interface PriceService {
    PriceResponse getApplicationPrice(PriceRequest priceRequest);
}
