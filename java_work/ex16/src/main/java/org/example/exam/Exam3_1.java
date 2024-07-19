package org.example.exam;

import java.util.Arrays;

class DoB {

    @Override
    public String toString() {
        return "DoB{}";
    }

    public static void doB(int[][] arr) {

        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < ; j++) {
                arr2[i] = arr[i][j];
            }
        }




        for (int[] arr2 : arr) {
            System.out.println(Arrays.toString(arr2));
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i]);
            }

        }
    }
}

public class Exam3_1 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{2,2,2,2},{5,6,7,8,9},{8,9,10}};

        DoB.doB(arr);
    }
}
