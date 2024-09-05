package com.cew.ex01.MyConf1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 객체 담는 통 정의
@Configuration
// 어떤 디렉토리를 읽어서 객체 주입 해달라
@ComponentScan(basePackages = "com.cew.ex01.member")
public class MyConf1 {
}
