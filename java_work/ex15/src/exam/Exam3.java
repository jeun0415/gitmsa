package exam;

class Solution {
    public int solution(int k, int m, int[] score) {
        int[] n = new int[1];
        for(int i=1; i<k;i++){
            if(score[i]<score[i+1]){
                n = score[i];
            }
            else{
                n = score[i+1];
            }
        }
        int n2 = System.out.println(n[0]);
        int answer = n2*m;
        return answer;
    }
}

public class Exam3 {
}
