package org.example.exam;

import lombok.AllArgsConstructor;

import java.util.Arrays;

/*
3. 다음 형태로 표현된 2차원 배열이 존재한다고 가정해보자
1   2    3   //1행
4   5    6   //2행
7   8    9   //3행
이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메소드를 정의하자
7   8    9   //1행
1   2    3   //2행
4   5    6   //3행
물론 배열의 가로와 세로길이에 상관없이 위와 같이 동작하도록 메소드를 정의해야 한다.
 */
@AllArgsConstructor
class DoA{

    public static void width(int[][] arr){
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num2 < arr[i].length){
                num2 = arr[i].length;
            }
        }
        int num1 = arr.length;
        int[][] arr2 = new int[num1][num2];

        for (int i = 0; i < num2; i++) {
            arr2[0][i] = arr[num1-1][i];
        }
        for (int i = 0; i < (num1-1); i++) {
            for (int j = 0; j < num2; j++) {
                arr2[i+1][j] = arr[i][j];
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }


    }
}

public class Exam3 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5},{2,2,2,2,2},{5,6,7,8,9},{8,9,10,11,12}};
        DoA.width(arr);
    }
}