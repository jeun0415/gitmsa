/*
10진수 입력받아 2진수 출력
 */
import java.util.Scanner;

// 클래스는 데이터(필드, 클래스 변수, 인스턴스 변수)와
// 메서드(함수, 클래스 함수, 인스턴스 함수)로 이루어져 있다.
class Exam{

    Scanner scan = new Scanner(System.in);

    public int inputNumber(){
        System.out.println("숫자 입력");
        int inputNumber = scan.nextInt();
        System.out.println("inputNumber().inputNumber = "+inputNumber);
        return inputNumber;
    }
}


public class Main {
    public static void main(String[] args) {
        Exam exam = new Exam();
        int result = exam.inputNumber();
        System.out.println("main.result = "+result);


        int 몫, 나머지;

        몫 = result/2;
        나머지 = result%2;

        System.out.println("몫 = "+몫);
        System.out.println("나머지 = "+나머지);

        String 나머지들 = "" + 나머지;
        // ㄴ이렇게 하면 숫자가 문자로 변환되어 들어감
        // ㄴ숫자 형태 그대로 이어지게 하기 위해 문자형태로 변환함

        while (true){

            나머지 = 몫%2;
            몫 = 몫/2;
            나머지들 = 나머지 + 나머지들;

            System.out.println("몫 = "+몫);
            System.out.println("나머지 = "+나머지);
            System.out.println("나머지들 = "+나머지들);

            if(몫 < 2){
                if(몫 != 0) {
                    나머지들 = 몫 + 나머지들;
                    System.out.println("나머지들 = " + 나머지들);
                }
                break;
            }

        }
    }
}