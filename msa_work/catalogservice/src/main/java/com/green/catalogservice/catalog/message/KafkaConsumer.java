package com.green.catalogservice.catalog.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final CatalogRepository catalogRepository;

    @KafkaListener(topics = "${spring.kafka.topic-name}")
    public void consumerMessage(String message){
        log.info("Received message: {}", message);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(message, Map.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 해당되는 ProductId 찾음, 없으면 빈 CatalogEntity 생성
        Optional<CatalogEntity> catalogEntity = catalogRepository.findByProductId((String) map.get("productId"));
        if (catalogEntity.isPresent()){
            // 찾은 제품에서 재고량 마이너스
            catalogEntity.get().setStock(catalogEntity.get().getStock() - (Integer) map.get("qty"));
            // catalogEntity 저장
            catalogRepository.save(catalogEntity.get());
        }else {
            // 데이터베이스에 없는 제품이면 처음부터 마이너스 숫자로 저장
            catalogRepository.save(
                    CatalogEntity.builder()
                            .productId((String) map.get("productId"))
                            .productName("제품명")
                            .stock((Integer) map.get("qty"))
                            .build()
            );
        }
    }
}
