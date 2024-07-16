package exam;
/*
2. 자바 클래스를 작성하는 연습을 해보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
        myTV.show();
    }
    출력
    LG에서 만든 2017년형 32인치 TV
 */
class TV{

    public void show(String str,int num1,int num2){
        System.out.println(str+"에서 만든 "+num1+"년형 "+num2+"인치 TV");
    }
}

public class Ex2 {

    public static void main(String[] args) {
        TV myTV = new TV(); //LG에서 만든 2017년 32인치
        myTV.show("LG",2017,32);
    }
}
