package exam;
/*
1. "Hello.java" 문자열에서 파일명인 Hello와 확장자인 java를 분리시켜보자.
    입력 >>Hello.java
    출력
    파일명 Hello
    확장자 java
*/

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        String str = "Hello.java";
//        char chars1 = str.charAt(0);
//        System.out.println(chars1);

        char[] chars1 = new char[5];
        char[] chars2 = new char[4];
        for (int i = 0; i < chars1.length; i++) {
            chars1[i] = str.charAt(i);
        }
        System.out.println("파일명 "+new String(chars1));
        //ㄴ 배열을 그냥 출력하면 배열내용이 출력되지만, 문자열과 함께 출력하면 주소값이 나옴
        //ㄴ 그래서 문자열과 함께 출력하려면 new String(chars1) or Arrays.toString(chars1) 형태로 해야 함

        for (int i = 0; i < chars2.length; i++) {
            chars2[(i)] = str.charAt((i+6));
        }
        System.out.print("확장자 ");
        System.out.println(chars2);


    }
}
