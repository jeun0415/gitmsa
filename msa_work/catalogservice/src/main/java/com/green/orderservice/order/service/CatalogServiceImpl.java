package com.green.orderservice.order.service;

import com.green.orderservice.error.CatalogException;
import com.green.userservice.jwt.JwtUtils;
import com.green.orderservice.order.jpa.CatalogEntity;
import com.green.orderservice.order.jpa.CatalogRepository;
import com.green.orderservice.order.vo.CatalogRequest;
import com.green.orderservice.order.vo.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final JwtUtils jwtUtils;

    @Override
    public CatalogResponse join(CatalogRequest catalogRequest) {

        String reqEmail = catalogRequest.getEmail();
        catalogRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new CatalogException(String.format("이미 존재하는 이메일입니다. \n 회원가입 할 수 없습니다. %s", reqEmail));});

        ModelMapper mapper = new ModelMapper();
        CatalogEntity catalogEntity = mapper.map(catalogRequest, CatalogEntity.class);
        catalogEntity.setUserId(UUID.randomUUID().toString());
        catalogEntity = catalogRepository.save(catalogEntity);

        CatalogResponse catalogResponse = mapper.map(catalogEntity, CatalogResponse.class);

        return catalogResponse;
    }

    @Override
    public CatalogResponse login(String email, String password) {

        CatalogEntity catalogEntity =
                catalogRepository.findByEmailAndPassword(email, password)
                        .orElseThrow(() -> new CatalogException("Invalid email or password"));

        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setUserId(catalogEntity.getUserId());
        catalogResponse.setAccessToken(jwtUtils.createAccessToken(catalogEntity.getEmail(), catalogEntity.getUserId()));
        catalogResponse.setRefreshToken(jwtUtils.createRefreshToken(catalogEntity.getEmail()));
        catalogResponse.setEmail(catalogEntity.getEmail());

        return catalogResponse;
    }
}
