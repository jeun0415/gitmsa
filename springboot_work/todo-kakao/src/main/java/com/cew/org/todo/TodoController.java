package com.cew.org.todo;

import com.cew.org.kakao.jpa.KakaoEntity;
import com.cew.org.kakao.jpa.KakaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@CrossOrigin
public class TodoController {

    private final TodoRepository todoRepository;
    private final KakaoRepository kakaoRepository;

    @PostMapping("save")
    public ResponseEntity<TodoEntity> saveTodo(@RequestBody TodoEntity todo,
        @AuthenticationPrincipal UserDetails userDetails){

//        UserDetails userDetails1 = (UserDetails)
//                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // FK 설정
        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(userDetails.getUsername());
        todo.setKakaoEntity(kakaoEntity);

        // 저장
        return ResponseEntity.ok(todoRepository.save(todo));
    }


    @GetMapping("findall")
    public ResponseEntity<List<TodoEntity>> findAllTodos(
            @AuthenticationPrincipal UserDetails userDetails
    ){
        System.out.println(userDetails);
        // 인증되지 않은 사용자가 todo를 요청한 경우
        if (userDetails == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 인증된 사용자가 todo를 요청한 경우
        String role = userDetails.getAuthorities().stream()
                .map(
                        authority -> authority.getAuthority()
                ).toString();

        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(userDetails.getUsername());
        List<TodoEntity> list = todoRepository.findAllByKakaoEntity(kakaoEntity);

        return ResponseEntity.ok(list);
    }
}
