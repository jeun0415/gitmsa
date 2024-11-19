package com.green.orderservice.order;

import com.green.orderservice.order.service.CatalogService;
import com.green.orderservice.order.vo.CatalogRequest;
import com.green.orderservice.order.vo.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;


    @PostMapping("join")
    public ResponseEntity<CatalogResponse> joinUser(@RequestBody CatalogRequest catalogRequest){

        CatalogResponse catalogResponse = catalogService.join(catalogRequest);
        System.out.println(catalogResponse);
        return ResponseEntity.ok(catalogResponse);
    }


    @GetMapping("login")
    public ResponseEntity<CatalogResponse> getUser(@RequestParam(value = "email") String email,
                                                   @RequestParam(value = "password") String password){

        CatalogResponse catalogResponse = catalogService.login(email, password);

        return ResponseEntity.ok(catalogResponse);
    }


    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin(){

        return ResponseEntity.ok(null);
    }
}
