package org.example;

import java.util.Scanner;

public class Exam3 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < (2*n-1); i++){
            for(int j = n-1 ;  j > 0  ; j-- ){
                System.out.print(" ");
            }
            for(int k = 0; k < n  ; k++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}