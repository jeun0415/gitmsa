package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6)
                .filter(n->n%2==1)
                .forEach(s-> System.out.println("나온 것 "+s));

        List<Member> list = Arrays.asList(
                new Member(1, "고길동", 20, "aaa@naver.com", "password"),
                new Member(2, "임예서", 30, "aaa@naver.com", "password"),
                new Member(3, "최포미", 40, "aaa@naver.com", "password")
        );

        // 나이의 최종 합
        // 나이가 30 이상인 사람 출력

        int result = 0;
        for (Member member : list){
            result += member.getAge();
            System.out.println(member);
        }
        System.out.println("나이의 최종 합 = "+result);

        // 나이 총합
        result = list.stream()
                    .mapToInt(s-> s.getAge())
                    .sum();

        System.out.println("나이의 최종 합 = "+result);

        // 30 이상인 사람 출력
        list.stream()
                .filter(m -> m.getAge()>=30)
                .forEach(member-> System.out.println(member.getName()));

        list.stream()
                .filter(m -> m.getAge()>=30)
                .mapToInt(m-> m.getAge())
                .forEach(age -> System.out.println(age));
    }
}
