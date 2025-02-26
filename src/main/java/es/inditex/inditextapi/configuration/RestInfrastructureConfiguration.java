package es.inditex.inditextapi.configuration;

import es.inditex.inditextapi.application.usecases.PriceService;
import es.inditex.inditextapi.infraestructure.rest.controller.PriceController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestInfrastructureConfiguration {

    @Bean
    public PriceController priceController(PriceService priceService) {
        return new PriceController(priceService);
    }

}
