package org.example;

import java.util.Arrays;
import java.util.List;

public class Ex05 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA","CCCC","BBB","DDDDD");

        // "EEEEEE"는 제일 처음 비교하는 기준이 되는 값
        String result = list.stream()
                .reduce("EEEEEE", (a,b)-> {
                    if (a.length() > b.length()) return a;
                    else return b;
                });

        System.out.println(result);

        // 문자열들을 나열해서 출력하고 싶음
        // AACCCCBBBDDDDD

        /*
            1. 생성
            2. 중간연산 : filter, map, sorted
            3. 최종연산
         */

        result = list.stream().sorted((s1,s2)-> s1.length()-s2.length())
                .reduce("", (a,b)-> a+b);
        System.out.println(result);
    }
}
