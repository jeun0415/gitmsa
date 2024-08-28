package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex06 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aaa","bbbb","ccccc","dddddd");

        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println();
        list.stream().map(s -> s.replace("aa","AA바꿈")).forEach(System.out::println);
        System.out.println();
        list.stream().map(s -> s.length()).forEach(System.out::println);
        System.out.println();



        // Optional map 메서드를 사용하게 되면 Optional<T> 반환됨
        // 안에 내용물이 없을 때는 orElse 사용해서 뭘 반환할지 작성할 수 있음
        Optional<String> os1 = Optional.of("abCD efg");
        Optional<String> os2 = os1.map(s -> s.toUpperCase());

        String result = os1.map(s -> s.toUpperCase()).orElse("EMPTY");
        System.out.println(result);

        System.out.println(os2);
        System.out.println(os2.get());

        Optional<String> os3 = os1.map(p -> p.replace(" ","_"))
                .map(p-> p.toLowerCase());

        System.out.println(os3);
        System.out.println(os3.get());

        os3.ifPresent(System.out::println);

        Optional<Integer> os4 = os1.map(s-> s.length());

        System.out.println(os4);
        System.out.println(os4.get());
    }
}
