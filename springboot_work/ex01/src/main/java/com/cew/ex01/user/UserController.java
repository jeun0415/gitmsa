package com.cew.ex01.user;

import com.cew.ex01.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    // getBean 함수로 가져오는 방법이었지만
    // 스프링 객체 담는 통에서 자동으로 가져오기
//    @Autowired
//    MemberRepository memberRepository;

    private final MemberRepository memberRepository;

    @GetMapping("member/insert")
    public String aa(@RequestParam(name = "name", defaultValue = "내이름") String name,
                     @RequestParam(name = "age", defaultValue = "30") int age){
        System.out.println("name = "+name);
        System.out.println("age = "+age);
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.insert(name,age);
        return "memberTable 저장했습니다.";
    }

    @GetMapping("bb")
    public String bb(){
        return "bb";
    }
}
