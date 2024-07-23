package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("a : ");
            int a = scan.nextInt();
            System.out.println("b : ");
            int b = scan.nextInt();

            System.out.println("나누기 시작");
            System.out.println(a / b);
            System.out.println("나누기 끝");

            int c[] = new int[3];
            System.out.println(c[4]);

        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("0으로 나눌 수 없습니다.");
        }
        catch (InputMismatchException ie){
            System.out.println("문자 넣으면 안돼요");
        }
        catch (Exception p){
            System.out.println("이것은 모든 예외 상황"+p.getMessage());
        }

        System.out.println("정상 종료 되었습니다.");
    }
}
