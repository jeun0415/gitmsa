package org.codereview;

public class p4_mainProblem {

//    static int[][] cache = new int[1000][3];
//    static int cnt;
    /**
     * 1. 메인문제 구현
     * 2. 함수호출 대충 그리기
     * 3. 깊이가 대충 7~8번 들어가고 3가지 갈래로 나눠지기 때문에
     * - 3^8 최악의 경우 거의 7000번?
     * 4. 3번때문에 같은 개수를 고른 함수가 여러개 나올 것임
     * - 크림빵 1 새우깡 2 콜라 4
     * - 위와 같이 여러번 호출됨
     * 5. 메모제이션으로 최초에 같은 제품을 골랐으면 바로 그 함수를 계산할 필요가 없으니 나와버림
     */
    static boolean[][][] cache = new boolean[10][10][10];
    public static void main(String[] args) {
        // 3500원으로 살 수있는 크림빵 500, 새우깡 700, 콜라 400
        // 각각 제품은 10개
        // 조건 각각 무조건 1개 이상은 사야함
        buyProducts(3500, 0, 0, 0);
    }

    private static void buyProducts(int n, int a, int b, int c) {
//        if(checkCache(a, b, c)) return;
        if(cache[a][b][c]) return;
        if(n < 0) return;
        if(n == 0) {
            // 몇개 샀는지 출력
            if(a > 0 && b > 0 && c > 0) {
//                cache[cnt][0] = a;
//                cache[cnt][1] = b;
//                cache[cnt][2] = c;
//                cnt++;
                cache[a][b][c] = true;
                System.out.println("크림빵 : " + a + " 새우깡 : " + b + " 콜라 : " + c);
            }
            return;
        }

        buyProducts(n - 500, a + 1, b, c);
        buyProducts(n - 700, a, b + 1, c);
        buyProducts(n - 400, a, b, c + 1);
    }

//    private static boolean checkCache(int a, int b, int c) {
//        for (int i = 0; i < cnt; i++) {
//            if(cache[i][0] == a && cache[i][1] == b && cache[i][2] == c) {
//                return true;
//            }
//        }
//        return false;
//    }
}
