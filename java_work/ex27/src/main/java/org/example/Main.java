package org.example;

public class Main {
    public static void main(String[] args) {

        MemberDto.MemberReqDto memberReqDto
                = new MemberDto.MemberReqDto("고길동",20);

        System.out.println(memberReqDto);

        MemberDto.MemberResDto memberResDto
                = new MemberDto.MemberResDto("고길동",20);

        System.out.println(memberResDto);

    }
}