package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(10,"고길동");
        map.put(20,"임예서");
        map.put(30,"최포미");
        map.put(40,"최포미");

        System.out.println(map);

        System.out.println(map.get(30));

        Set<Integer> set = map.keySet();  // 키 값을 모을 수 있음
        System.out.println(set);

        for (int key : set){
            System.out.println(map.get(key));
        }
    }
}