package com.cew.org.user;

import com.cew.org.kakao.jpa.KakaoEntity;
import com.cew.org.kakao.jpa.KakaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final KakaoRepository kakaoRepository;

    @GetMapping("info")
    public ResponseEntity<KakaoEntity> getUserInfo(
//            @RequestHeader("Authorization") String token,
            @AuthenticationPrincipal UserDetails userDetails){
        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(kakaoEntity);
    }
}
