package org.example;

import java.util.Set;
import java.util.TreeSet;

public class Ex02 {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        set.add(4);
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);

        Set<AAA> set1 = new TreeSet<>();
        AAA aaa1 = new AAA();
        aaa1.setName("고길동");
        aaa1.setAge(20);
        AAA aaa2 = new AAA();
        aaa2.setName("임하성");
        aaa2.setAge(1);
        AAA aaa3 = new AAA();
        aaa3.setName("최포미");
        aaa3.setAge(7);

        set1.add(aaa1);
        set1.add(aaa2);
        set1.add(aaa3);

        System.out.println(set1);
    }
}
