/*
1. 문자열을 입력받아 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
제한사항 1<= str의 길이 <=10
입력 #1
abcde
출력
a
b
c
d
e
 */

package exam;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("문자를 입력하시오.(최대 10개 글자수 제한)");
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        char chars[][] = new char[string.length()][string.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[0][i] = string.charAt(i);
        }
        for (int i = 1; i < chars.length; i++) {
            chars[i][0] = chars[0][i];
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i][0]);
        }
    }
}
