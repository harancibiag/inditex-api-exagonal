package es.inditex.inditextapi.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDTO {
    private Long priceList;
    private BrandDTO brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long priority;
    private BigDecimal priceAmount;
    private String curr;
}
