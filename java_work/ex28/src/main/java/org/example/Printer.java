package org.example;

interface Printable{
    void print();
}
public class Printer {
    public static void main(String[] args) {
        // 1. class 상속 받아서 하는 방법
        // 2. 익명 인터페이스
        // 3. 람다


        Printable printLamda = ()-> System.out.println("람다");
        printLamda.print();
    }
}
