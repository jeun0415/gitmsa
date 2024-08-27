package org.example;

public class Exam {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+i+1; k++) {
                System.out.print("*");
            }
            for (int j = 0; j < 4; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
