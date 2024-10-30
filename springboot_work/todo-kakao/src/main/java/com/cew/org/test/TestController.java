package com.cew.org.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("test/aa")
    public String testAA(){
        return "AA";
    }
}
