package org.example;

// interface는 꼭 한 개의 몸체가 없는 메서드가 있어야 된다.
interface AA{
    int doA();
    default void doB(){
        System.out.println("doB");
    } // 몸체가 있으면 괜찮음
    static void doC(){
        System.out.println("doC");
    }
}

public class Ex04 {

    public static void doMethod(AA aa){
        aa.doA();
        aa.doB();
        AA.doC();
    }

    public static void main(String[] args) {
        AA aa = ()-> 10;
        int result = aa.doA();
        System.out.println(result);
//        doMethod(  ()-> System.out.println("새로운 함수 정의")  );
    }
}
