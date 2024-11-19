package com.green.orderservice.order.service;

import com.green.orderservice.error.OrderException;
import com.green.userservice.jwt.JwtUtils;
import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final JwtUtils jwtUtils;

    @Override
    public OrderResponse join(OrderRequest orderRequest) {

        String reqEmail = orderRequest.getEmail();
        orderRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new OrderException(String.format("이미 존재하는 이메일입니다. \n 회원가입 할 수 없습니다. %s", reqEmail));});

        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = mapper.map(orderRequest, OrderEntity.class);
        orderEntity.setUserId(UUID.randomUUID().toString());
        orderEntity = orderRepository.save(orderEntity);

        OrderResponse orderResponse = mapper.map(orderEntity, OrderResponse.class);

        return orderResponse;
    }

    @Override
    public OrderResponse login(String email, String password) {

        OrderEntity orderEntity =
                orderRepository.findByEmailAndPassword(email, password)
                        .orElseThrow(() -> new OrderException("Invalid email or password"));

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUserId(orderEntity.getUserId());
        orderResponse.setAccessToken(jwtUtils.createAccessToken(orderEntity.getEmail(), orderEntity.getUserId()));
        orderResponse.setRefreshToken(jwtUtils.createRefreshToken(orderEntity.getEmail()));
        orderResponse.setEmail(orderEntity.getEmail());

        return orderResponse;
    }
}
