package org.example;

import org.example.test.*;

public class Ex02 {

    // 부모클래스에 자식클래스를 담을 수 있음
    // 자식클래스 생성했을 때 부모클래스로 참조할 수 있음
    // 자식클래스에 있어도 부모클래스에 없는것을 호출할 수 없음
    // 클래스 다형성

    public static void main(String[] args) {
        AA a1 = new BB();
        AA a2 = new CC();

        a1.bb();
        a2.cc();

    }
}
