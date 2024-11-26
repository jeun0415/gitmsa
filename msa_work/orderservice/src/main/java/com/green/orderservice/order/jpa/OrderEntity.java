package com.green.orderservice.order.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class OrderEntity implements Serializable {

    // 자동 증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // product service
    @Column(nullable = false, length = 120)
    private String productId;

    // 주문수량
    @Column(nullable = false)
    private Integer qty;

    // 주문가격
    @Column(nullable = false)
    private Integer unitPrice;

    // 주문수량 * 주문가격
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;

    // UUID 생성예정
    @Column(nullable = false, unique = true)
    private String orderId;

    // 주문 생성시간
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

}