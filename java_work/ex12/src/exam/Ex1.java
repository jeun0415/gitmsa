package exam;


public class Ex1 {

    public static void main(String[] args) {
        int a[] = {10,20,30,40,50};
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println("총합 = "+sum);
        System.out.println("평균 = "+(sum/a.length));

    }
}
