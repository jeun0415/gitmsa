package aa;

// 클래스 정의
public class Box {
    String name;
    int count;


    //접근제어지시자
    //public protected default private


    //기본생성자는 생략 가능하지만
    //다른 생성자를 선언할시 기본생성자 생략 불가
    //그래서 기본생성자 호출해야함
    public Box(){
        System.out.println("기본생성자 호출");
    }
    public Box(String n){
        name = n;
        System.out.println("n 다른 생성자 호출");

    }
    public Box(String n,int c){
        name = n;
        count = c;
        System.out.println("n c 다른 생성자 호출");

    }





    //생략..
    // 원래 toString은 주소값 출력
    //개발자 프로그래머가 직접 적게 되면 내용이 바뀜
    public String toString(){
        return "Box name = "+name+" count = "+count;
    }

}


/* 메서드 이름이 동일할 수 없음
괄호 안에 뭐가 들어가면 괜찮음
public void doA(){}
public void doA(String a){}
*/