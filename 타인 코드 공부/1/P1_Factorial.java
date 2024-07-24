package org.codereview;

public class P1_Factorial {
    /**
     * whiteboard 준비
     * 0. 재귀를 선택한 이유
     * 1. JVM(자바 가상 머신) 스택 설명
     * 2. 자료구조 간단히 설명
     * 2. 스택 개념 설명, 이중 주차/밑에 책 꺼내기
     * 3. 팩토리얼 구현 후 이동 절차 설명
     * 4. 재귀를 쓸 때 중요한 점
     *    - 탈출조건(규칙을 찾아서 변수가 작아지거나 커짐) 및 호출순서
     */
    public static void main(String[] args) {

        int n = 5;

        int res = fact(n);
        System.out.println(res);
    }

    private static int fact(int n) {
        if(n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }


}
