package es.inditex.inditextapi.configuration;

import es.inditex.inditextapi.application.mapper.PriceResponseMapper;
import es.inditex.inditextapi.application.services.PriceManagementService;
import es.inditex.inditextapi.application.services.SecurityManagementService;
import es.inditex.inditextapi.application.usecases.PriceService;
import es.inditex.inditextapi.application.usecases.SecurityService;
import es.inditex.inditextapi.domain.ports.input.PricePersistencePort;
import es.inditex.inditextapi.domain.ports.input.SecurityPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public PriceService priceService(PricePersistencePort pricePersistencePort, PriceResponseMapper priceResponseMapper) {
        return new PriceManagementService(pricePersistencePort, priceResponseMapper);
    }
    @Bean
    public SecurityService securityService(SecurityPersistencePort securityPersistencePort) {
        return new SecurityManagementService(securityPersistencePort);
    }


}
