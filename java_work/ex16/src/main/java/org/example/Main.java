package org.example;

/*
1. exam.Student 클래스를 작성하는 연습을 해보도록하자.
exam.Student 클래스에 getTotal() getAverage() 과 를 추가하시오
1. :  getTotal 메서드
기 능 국어 영어 수학 의 점수를 모두 더해서 반환한다 :
(kor), (eng), (math) .
반환타입 : int
        매개변수 없음 :
 */

import org.example.aa.Student;

public class Main {

    Main(){
        Student student = new Student(
                "홍길동",90,80,60);
        System.out.println(student);
        System.out.println(student.getAverage());
        System.out.println(student.getTotal());
    }
    public static void main(String[] args) {

        new Main();
    }
}