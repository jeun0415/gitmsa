package com.cew.org.kakao;

import com.cew.org.kakao.dto.KakaoTokenDto;
import com.cew.org.kakao.dto.KakaoUserInfoDto;
import com.cew.org.kakao.jpa.KakaoEntity;
import com.cew.org.kakao.jpa.KakaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoRepository kakaoRepository;

    public void getToken(String code) {
        // 1. restTemplate
        try {
            // ----- 토큰 가져오기 -----
            String url = "https://kauth.kakao.com/oauth/token";
            RestTemplate restTemplate = new RestTemplate();

            // header 내용
            MultiValueMap headers = new LinkedMultiValueMap();
            headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // body 내용
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", "1692f4090898eb1a60d5c44c13a050e5");
            body.add("redirect_uri", "http://localhost:5173/oauth");
            body.add("code", code);
            body.add("client_secret", "4gh5yoOY3hxULqApA1LzzCNFDCASNFMH");

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

            // 카카오 서버랑 통신
            ResponseEntity<KakaoTokenDto> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, KakaoTokenDto.class);
            log.info("result {}", result);
            KakaoTokenDto kakaoTokenDto = result.getBody();

            // 유저 정보 가져오기 시작
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer "+kakaoTokenDto.getAccess_token());

            ResponseEntity<KakaoUserInfoDto> res = restTemplate.exchange("https://kapi.kakao.com/v2/user/me"
                , HttpMethod.GET
                , new HttpEntity<>(null, httpHeaders)
                , KakaoUserInfoDto.class);

//            System.out.println("KakaoUserInfoDto = "+res.getBody());

            KakaoUserInfoDto kakaoUserInfoDto = res.getBody();

            // 유저 정보 가져오기 끝
            KakaoEntity kakaoEntity = new ModelMapper()
                    .map(kakaoTokenDto, KakaoEntity.class);
            kakaoEntity.setEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
            kakaoEntity.setNickname(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
            kakaoEntity.setProfile_image(kakaoUserInfoDto.getProperties().getProfileImage());
            kakaoEntity.setThumbnail_image(kakaoUserInfoDto.getProperties().getThumbnailImage());

            // userId 중복 안되게 생성
            kakaoEntity.setUserId(UUID.randomUUID().toString());

            kakaoRepository.save(kakaoEntity);
            // DB 저장

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void messageSend(String email, String message) {

        RestTemplate restTemplate = new RestTemplate();
        // ----- 토큰 가져오기 끝 / 메시지 보내기 시작 -----
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        MultiValueMap headers2 = new LinkedMultiValueMap();
        headers2.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//        headers2.add("Authorization", "Bearer " + kakaoTokenDto.getAccess_token());

        MultiValueMap<String, String> body2 = new LinkedMultiValueMap<>();
        body2.add("template_object", String.format(templateString(), "aaa@naver.com"));

        HttpEntity<MultiValueMap<String, String>> requestEntity2 = new HttpEntity<>(body2, headers2);

        ResponseEntity<String> result2 = restTemplate.exchange(url, HttpMethod.POST, requestEntity2, String.class);

        log.info("msg 카카오톡 메시지 전송 성공" + result2.toString());

    }


    public String templateString(){
        return "{\n" +
                "        \"object_type\": \"feed\",\n" +
                "        \"content\": {\n" +
                "            \"title\": \"%s님 공짜 간식 당첨 축하드려요\",\n" +
                "            \"description\": \"아메리카노, 빵, 케익\",\n" +
                "            \"image_url\": \"https://mud-kage.kakao.com/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg\",\n" +
                "            \"image_width\": 640,\n" +
                "            \"image_height\": 640,\n" +
                "            \"link\": {\n" +
                "                \"web_url\": \"http://www.daum.net\",\n" +
                "                \"mobile_web_url\": \"http://m.daum.net\",\n" +
                "                \"android_execution_params\": \"contentId=100\",\n" +
                "                \"ios_execution_params\": \"contentId=100\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"item_content\" : {\n" +
                "            \"profile_text\" :\"Kakao\",\n" +
                "            \"profile_image_url\" :\"https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png\",\n" +
                "            \"title_image_url\" : \"https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png\",\n" +
                "            \"title_image_text\" :\"Cheese cake\",\n" +
                "            \"title_image_category\" : \"Cake\",\n" +
                "            \"items\" : [\n" +
                "                {\n" +
                "                    \"item\" :\"Cake1\",\n" +
                "                    \"item_op\" : \"1000원\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"item\" :\"Cake2\",\n" +
                "                    \"item_op\" : \"2000원\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"item\" :\"Cake3\",\n" +
                "                    \"item_op\" : \"3000원\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"item\" :\"Cake4\",\n" +
                "                    \"item_op\" : \"4000원\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"item\" :\"Cake5\",\n" +
                "                    \"item_op\" : \"5000원\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"sum\" :\"Total\",\n" +
                "            \"sum_op\" : \"15000원\"\n" +
                "        },\n" +
                "        \"social\": {\n" +
                "            \"like_count\": 100,\n" +
                "            \"comment_count\": 200,\n" +
                "            \"shared_count\": 300,\n" +
                "            \"view_count\": 400,\n" +
                "            \"subscriber_count\": 500\n" +
                "        },\n" +
                "        \"buttons\": [\n" +
                "            {\n" +
                "                \"title\": \"웹으로 이동\",\n" +
                "                \"link\": {\n" +
                "                    \"web_url\": \"http://www.daum.net\",\n" +
                "                    \"mobile_web_url\": \"http://m.daum.net\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"title\": \"앱으로 이동\",\n" +
                "                \"link\": {\n" +
                "                    \"android_execution_params\": \"contentId=100\",\n" +
                "                    \"ios_execution_params\": \"contentId=100\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
    }
}
