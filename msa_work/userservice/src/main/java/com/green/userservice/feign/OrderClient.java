package com.green.userservice.feign;

import com.green.userservice.user.vo.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service", url = "${order-service-url}")
public interface OrderClient {

    @GetMapping("order-service/{userId}/order")
    List<OrderResponse> getOrders(@PathVariable(value = "userId") String userId);
}
