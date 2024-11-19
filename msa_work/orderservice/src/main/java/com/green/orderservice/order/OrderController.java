package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("join")
    public ResponseEntity<OrderResponse> joinUser(@RequestBody OrderRequest orderRequest){

        OrderResponse orderResponse = orderService.join(orderRequest);
        System.out.println(orderResponse);
        return ResponseEntity.ok(orderResponse);
    }


    @GetMapping("login")
    public ResponseEntity<OrderResponse> getUser(@RequestParam(value = "email") String email,
                                                 @RequestParam(value = "password") String password){

        OrderResponse orderResponse = orderService.login(email, password);

        return ResponseEntity.ok(orderResponse);
    }


    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin(){

        return ResponseEntity.ok(null);
    }
}
