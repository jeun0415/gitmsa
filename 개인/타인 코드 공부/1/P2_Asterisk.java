package org.codereview;

public class P2_Asterisk {
    /**
     * 1. 만약 함수를 자기 자신을 두번이상 호출하면 어떻게 될까?
     * 스택을 여전히 쓰지만 패러다임이 바뀜
     * 2. 별찍기 구현
     * 3. 그림그려가며 함수 호출순서 깊이와 가지 수 설명
     * 4. 트리 구조 설명
     */
    public static void main(String[] args) {

        int n = 3;

        asterisk(n);
    }

    private static void asterisk(int n) {
        if(n == 0) return;

        System.out.println("*");
        asterisk(n - 1);
        asterisk(n - 1);
    }
}
