
package es.inditex.inditextapi.application.services;

import es.inditex.inditextapi.application.services.validators.PriceValidator;
import es.inditex.inditextapi.domain.dto.request.PriceRequest;
import es.inditex.inditextapi.domain.dto.response.PriceResponse;
import es.inditex.inditextapi.domain.ports.input.PricePersistencePort;
import es.inditex.inditextapi.application.usecases.PriceService;
import es.inditex.inditextapi.domain.model.Price;
import es.inditex.inditextapi.application.mapper.PriceResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceManagementService implements PriceService {

    private final PricePersistencePort pricePersistencePort;
    private final PriceResponseMapper priceResponseMapper;

    @Autowired
    public PriceManagementService(final PricePersistencePort pricePersistencePort,
                                  final PriceResponseMapper priceResponseMapper) {
        this.pricePersistencePort = pricePersistencePort;
        this.priceResponseMapper = priceResponseMapper;
    }

    @Override
    public PriceResponse getApplicationPrice(PriceRequest priceRequest) {
        PriceValidator priceValidator = new PriceValidator();
        priceValidator.validate(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        Price price = pricePersistencePort.findApplicablePrice(priceRequest);
        return priceResponseMapper.toResponse(price);
    }

}


