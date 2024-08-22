package org.example;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("BOX");
        set.add("TOY");
        set.add("BOX");
        set.add("ROBOT");

        System.out.println(set);

        // equals 메소드로 동일 인스턴스인지 판단

//        set.add(new String("BOX"));
//        System.out.println(set);

        System.out.println("BOX".hashCode());
        System.out.println(new String("BOX").hashCode());

        Set<AAA> set1 = new HashSet<>();
        set1.add(new AAA());
        set1.add(new AAA());

        System.out.println(set1);

        System.out.println(new AAA().hashCode());
        System.out.println(new AAA().hashCode());
    }
}
