package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;

public interface OrderService {

    OrderResponse join(OrderRequest orderRequest);

    OrderResponse login(String email, String password);
}
