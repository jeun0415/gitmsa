package com.cew.ex04.test;

import com.cew.ex04.obj.AA;
import com.cew.ex04.obj.BB;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    // 스프링컨테이너 직접 관리하는 방식
    private final AA aa;
    private final BB bb;

    // JVM 직접 관리
//    AA aa = new AA();

    @GetMapping("aa")
    public String aa(){
        aa.doA();
        return "aaaaa";
    }

    @PostMapping("bb")
    public String bb(){
        bb.doB();
        return "bbbbb";
    }
}
