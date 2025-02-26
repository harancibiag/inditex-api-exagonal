package es.inditex.inditextapi.infraestructure.adapter;

import es.inditex.inditextapi.domain.dto.request.PriceRequest;
import es.inditex.inditextapi.domain.model.Price;
import es.inditex.inditextapi.domain.ports.input.PricePersistencePort;
import es.inditex.inditextapi.infraestructure.adapter.entity.PriceEntity;
import es.inditex.inditextapi.infraestructure.adapter.mapper.PriceDboMapper;
import es.inditex.inditextapi.infraestructure.adapter.repository.PriceJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PriceJpaAdapter implements PricePersistencePort {
    private final PriceJpaRepository priceJpaRepository;
    private final PriceDboMapper priceDboMapper;

    public PriceJpaAdapter(PriceJpaRepository priceJpaRepository, PriceDboMapper priceDboMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceDboMapper = priceDboMapper;
    }

    public Price findApplicablePrice(PriceRequest priceRequest) {
        PriceEntity priceEntity = priceJpaRepository.findApplicablePrice(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        return priceDboMapper.toDomain(priceEntity);
    }

}
