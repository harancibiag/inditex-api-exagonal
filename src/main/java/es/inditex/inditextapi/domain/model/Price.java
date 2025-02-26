package es.inditex.inditextapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price {
    private Long priceList;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long priority;
    private BigDecimal priceAmount;
    private String curr;
}
