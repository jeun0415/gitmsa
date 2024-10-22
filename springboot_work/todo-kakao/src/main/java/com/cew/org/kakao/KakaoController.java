package com.cew.org.kakao;

import com.cew.org.kakao.dto.KakaoMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kakao")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("login")
    public String kakaoCode(@RequestParam String code){
        log.info("code {}", code);

        kakaoService.getToken(code);
//        kakaoService.messageSend();

        return "kakao join success";
    }


    @PostMapping("messagesend")
    public String messageSend(@RequestBody KakaoMessageDto kakaoMessageDto){
        kakaoService.messageSend(
                kakaoMessageDto.getEmail(),
                kakaoMessageDto.getMessage());
        return "message send success";
    }
}
