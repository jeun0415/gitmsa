package com.green.orderservice.order.vo;

import lombok.Data;

@Data
public class CatalogResponse {

    private Long id;

    private String email;

    private String userId;

    private String name;

    private String password;
}
