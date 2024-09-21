package org.codereview;

public class P3_Fibonacci {

    /**
     * 0. 함수 두개 이상 쓰는 예제
     * 1. 피보나치 구현
     * 2. 재귀함수의 단점 : 함수호출 비용, 같은 함수 여러번 호출
     * 3. 메모제이션 소개
     */
    static int[] cache = new int[1000];
    public static void main(String[] args) {
        System.out.println(fibo(4));
    }

    // 0 1 1 2 3
    private static int fibo(int n) {
        if(cache[n] > 0) return cache[n];
        if(n == 0) return 0;
        if(n == 1) return 1;

        return cache[n] = fibo(n - 2) + fibo(n - 1);
    }
}
