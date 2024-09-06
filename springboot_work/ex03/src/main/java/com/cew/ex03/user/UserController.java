package com.cew.ex03.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // url 맵하는 클래스야
@RequestMapping("user") // 주소줄에 user로 시작하는거야
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("select")
    public List<User> select(){
        return userRepository.findAll();
    }

    @PostMapping("insert")
    public String insert(@RequestBody User user){
        System.out.println("실행");
        user.setWdate(LocalDateTime.now());
        // save insert 실행
//        User user = User.builder()
//                .name("최포미")
//                .age(7)
//                .email("nyamnyam@naver.com")
//                .password("beef")
//                .wdate(LocalDateTime.now())
//                .build();

        System.out.println(user);

        userRepository.save(user);
        return "ok";
    }
}
