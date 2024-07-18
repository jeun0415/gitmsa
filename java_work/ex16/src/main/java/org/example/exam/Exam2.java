package org.example.exam;

import lombok.AllArgsConstructor;

import java.util.Arrays;

/*
2. 다음 메소드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달된 값의 크기만큼 전부 증가시킨다.
public static void addOneDArr(int[] arr, int add){
    for(int i =0; i<arr.length; i++){
        arr[i] += add;
    }
}
위 메소드를 호출하는 형태로, int형 2차원 배열에 저장된 값 전부를 두번째 매개변수로 전달된 값의 크기만큼
증가시키는 메소드를 다음의 형태로 정의하자
public static void addTwoDArr(int[][] arr, int add){
    // 이안에 addOneDArr 메소드를 호출한다.
}
 */
@AllArgsConstructor
class Add{


    public static void addOneDArr(int[] arr, int add){
        for(int i =0; i<arr.length; i++){
            arr[i] += add;
        }
    }
    public static void addTwoDArr(int[][] arr, int add){
        int[] num1 = new int[5];
        int[] num2 = new int[5];
        for (int i = 0; i <2 ; i++) {
            if (i == 0) {
                for (int j = 0; j < 5; j++) {
                    num1[j] = arr[i][j];
                }
            }
            else {
                for (int j = 0; j < 5; j++) {
                    num2[j] = arr[i][j];
                }
            }
        }
        addOneDArr(num1,add);
        addOneDArr(num2,add);
        for (int i = 0; i <2 ; i++) {
            if (i == 0) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = num1[j];
                }
            }
            else {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = num2[j];
                }
            }
        }
        // 이안에 addOneDArr 메소드를 호출한다.
    }
}

public class Exam2 {
    public static void main(String[] args) {
        int[][] arr2 = {{10,20,30,40,50},{60,70,80,90,100}};
        Add.addTwoDArr(arr2,6);

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }


    }
}
