package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.CatalogRequest;
import com.green.orderservice.order.vo.CatalogResponse;

public interface CatalogService {

    CatalogResponse join(CatalogRequest catalogRequest);

    CatalogResponse login(String email, String password);
}
