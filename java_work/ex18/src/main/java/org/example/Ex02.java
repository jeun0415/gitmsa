package org.example;

// 3번 문제

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {

    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        int temp0[] = arr[0];
        int temp1[] = arr[1];
        int temp2[] = arr[2];

        arr[0] = temp2;
        arr[1] = temp0;
        arr[2] = temp1;


        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));

    }
}
