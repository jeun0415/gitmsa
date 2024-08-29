package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // list 1,2,3,4,5,6,7,8,9 생성해서 스트림으로 만들어서
        // 1. 그냥 출력
        // 2. 홀수, 짝수 sum 총합 출력하기

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list.stream().forEach(System.out::println);

        int result = list.stream().mapToInt(value -> value).sum();
        System.out.println("result = "+result);

        result = list.stream().reduce(0,(a, b) -> a+b);
        System.out.println("result = "+result);

        result = list.stream().filter(i -> i%2==0)
                .reduce(0,(a, b) -> a+b);
        System.out.println("result = "+result);

        result = list.stream().filter(i -> i%2==1)
                .reduce(0,(a, b) -> a+b);
        System.out.println("result = "+result);
    }
}