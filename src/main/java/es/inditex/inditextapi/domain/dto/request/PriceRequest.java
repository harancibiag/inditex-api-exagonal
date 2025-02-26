package es.inditex.inditextapi.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceRequest {
    LocalDateTime applicationDate;
    Long productId;
    Long brandId;
}
