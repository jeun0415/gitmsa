/*
3. 다음은 answer 배열 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 ‘*’을 찍어서
그래프를 그리는 프로그램이다 에 알맞은 코드를 넣어서 완성하시오 .
int[] answer = { 1,4,4,3,1,4,4,2,1,3,2}
실행결과
1***
2**
3**
4****
 */
package exam;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        for (int i = 0; i < 11; i++) {
            int a = answer[i];

            if (a == 1) {
                num1++;
            } else if (a == 2) {
                num2++;
            } else if (a == 3) {
                num3++;
            } else if (a == 4) {
                num4++;
            }
        }

        String str1[] = new String[num1];
        String str2[] = new String[num2];
        String str3[] = new String[num3];
        String str4[] = new String[num4];

        Arrays.fill(str1, "*");
        Arrays.fill(str2, "*");
        Arrays.fill(str3, "*");
        Arrays.fill(str4, "*");

        System.out.println("1" + Arrays.toString(str1));
        System.out.println("2" + Arrays.toString(str2));
        System.out.println("3" + Arrays.toString(str3));
        System.out.println("4" + Arrays.toString(str4));

        System.out.print("1");
        for (int i = 0; i < str1.length; i++) {
            System.out.print(str1[i]);
        }
        System.out.println();
        System.out.print("2");
        for (int i = 0; i < str2.length; i++) {
            System.out.print(str2[i]);
        }
        System.out.println();
        System.out.print("3");
        for (int i = 0; i < str3.length; i++) {
            System.out.print(str3[i]);
        }
        System.out.println();
        System.out.print("4");
        for (int i = 0; i < str4.length; i++) {
            System.out.print(str4[i]);
        }

    }
}
