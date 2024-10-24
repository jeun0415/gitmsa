package com.cew.org.kakao;

import com.cew.org.kakao.dto.KakaoMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kakao")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class KakaoController {

    private final KakaoService kakaoService;


    @GetMapping("login")
    public ResponseEntity<String> kakaoCode(@RequestParam String code){

        String jwt = kakaoService.getToken(code);
        if(jwt.equals("fail"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인에 실패하였습니다.");
        else
            return ResponseEntity.ok(jwt);
//        kakaoService.messageSend();


    }


    @GetMapping("msg")
    public ResponseEntity<String> messageSend(@RequestParam(value = "message") String message,
                              @RequestHeader(value = "Authorization", required = false) String authorization){

        log.info(authorization);
        try{
            String jwt = authorization.split("Bearer ")[1];
            kakaoService.messageSend(jwt, message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("jwt empty");
        }

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // jwt
//        kakaoService.messageSend(email, message);
        return ResponseEntity.ok("message send success");
    }
}
