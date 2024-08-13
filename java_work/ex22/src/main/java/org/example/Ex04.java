package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ex04 {

    public static <T> Box<T> makeBox(T t){
        Box<T> box = new Box<>();
        box.setObj(t);
        return box;
    }

    public static void main(String[] args) {

        Box<String> box1 = makeBox("test");
        Box<Integer> box2 = Ex04.makeBox(20);

        System.out.println(box1);
        System.out.println(box2);

        // 배열 범위를 넘어섰을 때 오류가 나는 것을 방지하기 위해 생김
        List<String> list = Arrays.asList("고길동","길동","동");
        List<Integer> ilist = list
                            .stream()
                            .mapToInt(value -> value.length())
                            .boxed()
                            .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(ilist);
    }
}
