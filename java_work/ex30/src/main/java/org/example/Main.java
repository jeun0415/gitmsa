package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        // [1,3,5,7,9] -> [9,7,5,3,1] 바꾸기
        List<Integer> list = Arrays.asList(1,3,5,7,9);
//        list = new ArrayList<>(list);

//        System.out.println(list);


        list.stream().forEach(s-> System.out.println(s));
        list.stream().forEach(System.out::println);


        // consumer
//        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
//            @Override
//            public void accept(List<Integer> integers) {
//                Collections.reverse(integers);
//            }
//        };

//        Consumer<List<Integer>> consumer = mylist -> Collections.reverse(mylist);

        // 그대로 전달한다는 약속에 한해서 사용 가능
//        Consumer<List<Integer>> consumer = Collections::reverse;
//        consumer.accept(list);
//
//        System.out.println(list);
    }
}