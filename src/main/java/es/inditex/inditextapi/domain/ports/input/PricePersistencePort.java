package es.inditex.inditextapi.domain.ports.input;

import es.inditex.inditextapi.domain.dto.request.PriceRequest;
import es.inditex.inditextapi.domain.model.Price;

public interface PricePersistencePort {
    Price findApplicablePrice(PriceRequest priceRequest);
}
