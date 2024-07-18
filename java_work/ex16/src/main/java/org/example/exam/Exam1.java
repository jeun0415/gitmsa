package org.example.exam;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Scanner;

/*
1. int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최댓값,최솟값을 찾아서 반환하는 메소드를
각각 다음의 형태로 정의하자
public static int minValue(int[] arr){}
public static int maxValue(int[] arr){}

단 반복문을 사용할때 minValue의 정의에서는 일반적인 for문을 사용하고 maxValue의 정의에서는
새로운 for(enhanced for문)을 사용하기로 하자
 */
@AllArgsConstructor

class Value{
    private int[] arr;

    public static int minValue(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]){
                if (arr[0] > arr[i]){
                    arr[0] = arr[i];
                }
            }
        }
        int num1 = arr[0];
        return num1;
    }

    public static int maxValue(int[] arr){
        int[] a = new int[1];
        for(int n : arr){
            if (a[0] < n){
                a[0] = n;
            }
        }
        int num2 = a[0];
        return num2;
    }

}

public class Exam1 {

    public static void main(String[] args) {

        int[] arr = {11,8,25,39,62,40,1,2,3,4,9,80,100};

        System.out.println(Value.minValue(arr));
        System.out.println(Value.maxValue(arr));

    }
}
