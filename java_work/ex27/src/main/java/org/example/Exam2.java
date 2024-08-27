package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {

            int ni = scan.nextInt();
            int nj = scan.nextInt();
            int nk = scan.nextInt();

            for (int j = ni-1; j < nj; j++) {
                arr[j] = nk;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
