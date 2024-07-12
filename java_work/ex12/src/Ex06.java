
class A{
    int a;
}


public class Ex06 {

    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5};
        int br[] = ar;

        br[0] = 10;

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        System.out.println();

        for (int i = 0; i < br.length; i++) {
            System.out.println(br[i]);
        }

        A a = new A();
        A b = a;
        a.a = 10;
        System.out.println("a.name = "+a.a);
        System.out.println("b.name = "+b.a);

        // 참조변수 특성에 따라 같은 곳을 가리키고 있기 때문에 같이 변함

    }
}
