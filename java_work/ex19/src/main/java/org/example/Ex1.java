package org.example;

/*

길이가 10인 배열을 선언하고 총 10개의 정수를 입력 받아서,
홀수와 짝수를 구분 지어 출력하는 프로그램을 작성해 보자.
일단 홀수부터 출력하고 나서 짝수를 출력하도록 하자.
단, 10개의 정수는 main 함수 내에서 입력받도록 하고,
배열 내에 존재하는 홀수만 출력하는 함수와 배열 내에 존재하는 짝수만 출력하는 함수를 각각 정의해서
이 두 함수를 호출하는 방식으로 프로그램을 완성하자.

*/

import java.util.Scanner;

class A {
    public void a1(int nn) {
        if (nn % 2 != 0) {
            System.out.println(nn);
        }
    }
}

class C {
    public void c(int nn) {
        if (nn % 2 == 0) {
            System.out.println(nn);
        }
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 10개를 입력하시오.");
        int a[] = new int[10];
        A call1 = new A();
        C call2 = new C();

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("홀수 정수는 = ");
        for (int j = 0; j < 10; j++) {
            call1.a1(a[j]);
        }
        System.out.println("짝수 정수는 = ");

    }
}