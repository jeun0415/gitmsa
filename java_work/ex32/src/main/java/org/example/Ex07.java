package org.example;

import org.example.member.Member;
import org.example.member.MemberRepository;

import java.util.Scanner;

public class Ex07 {

    private MemberRepository memberRepository = new MemberRepository();

    public static Member member;

    Ex07(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    뭐할래?
                    0. 로그인
                    
                    1. member select()
                    2. member insert()
                    3. member update()
                    4. member delete()
                    
                    5. todo select() -> user 사용자
                    6. todo insert() -> user 정보
                    7. todo update()
                    8. todo delete()
                    """);
            int ra = scanner.nextInt();

            if (ra == 0) {
                // 사용자가 있으면 member_idx 지정
                System.out.println("어떤 사용자 할래? 몇 번?");
                int member_idx = scanner.nextInt();
                member = memberRepository.findByIdx(member_idx);
                if (member == null){
                    System.out.println("로그인 실패");
                }
                else {
                    System.out.println("로그인 성공");
                }
                System.out.println(Ex07.member);

            } else if (ra == 1) {
                memberRepository.select();
            } else if (ra == 2) {
                memberRepository.insert();
            } else if (ra == 6) {

            } else {
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Ex07();
    }
}
