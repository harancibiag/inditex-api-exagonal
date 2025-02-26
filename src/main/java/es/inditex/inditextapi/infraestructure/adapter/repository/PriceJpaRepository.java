package es.inditex.inditextapi.infraestructure.adapter.repository;

import es.inditex.inditextapi.infraestructure.adapter.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {
    @Query(value = "SELECT PRODUCT_ID, BRAND_ID,  PRICE_LIST,  START_DATE, END_DATE, PRICE, CURR, PRIORITY FROM PRICES " +
            "WHERE BRAND_ID = :brandId " +
            "AND PRODUCT_ID = :productId " +
            "AND :applicationDate BETWEEN START_DATE AND END_DATE " +
            "ORDER BY PRIORITY DESC LIMIT 1",
            nativeQuery = true)
    PriceEntity findApplicablePrice(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);
}
