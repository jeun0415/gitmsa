package org.example;

import java.util.Random;

@FunctionalInterface
interface RAN{

    // 반환 값이 있고 매개변수가 없는 함수
    int ran();
}

public class Ex02 {

    public static void main(String[] args) {

        RAN ran = ()-> new Random().nextInt(50);
        for (int i = 0; i < 10; i++)
            System.out.println(ran.ran());

        System.out.println();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(50));
        }
    }
}
