package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);

        System.out.println("!!!한번 답하면 끝날 때까지 수정할 수 없습니다!!!");
        System.out.println("성별을 고르시오");
        System.out.println("1. 남자   2. 여자");
        int gender = scan1.nextInt();
        System.out.println();

        System.out.println("만나이를 숫자만 입력하시오");
        int age = scan1.nextInt();
        System.out.println();

        System.out.println("키를 cm 단위로 숫자만 입력하시오");
        double height = scan1.nextDouble();
        System.out.println();

        System.out.println("몸무게를 kg 단위로 숫자만 입력하시오");
        double weight = scan1.nextDouble();
        System.out.println();

        while (true) {

            System.out.println("구하고 싶은 것을 선택하여 숫자를 입력하시오");
            System.out.println("1  BMI(체질량지수)");
            System.out.println("2  표준체중");
            System.out.println("3  표준체중 기준 하루 권장 칼로리");
            System.out.println("4  내 체중 기준 하루 권장 칼로리");
            System.out.println();

            Scanner scan2 = new Scanner(System.in);
            int num = scan2.nextInt();
            Health health = new Health(gender, age, height, weight);

            if (num == 1) {
                health.bmi();

            } else if (num == 2) {
                double result = health.averweight();
                System.out.println("표준체중 : " + result + "kg");

            } else if (num == 3) {
                health.akcal();

            } else if (num == 4) {
                health.mykcal();

            }else {
                System.out.println();
                System.out.println("!!!숫자를 보기 안에서 골라주세요!!!");
                System.out.println();
            }

            System.out.println();
            System.out.println("계속 하시나요? 숫자를 입력해주세요");
            System.out.println("0 그만한다  1 더 알아본다");
            int answer = scan2.nextInt();
            if (answer == 0) {
                break;
            }
        }
        System.out.println("종료되었습니다.");
    }
}