package org.example;

import java.util.Arrays;

/*
1. Person 클래스에서 comparable을 상속받아 compareTo메서드를 재정의해서
이름글자의 갯수로 오름차순 내림차순으로 하였는데,
이 탐색의 기준이 이름(사전편찬순으로) 되도록 수정해보자.
ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ,ㅅ
*/
class Person implements Comparable<Person>{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        name.charAt(0);

        return this.name.char - o.name.length();
    }


}


public class Exam01 {
    public static void main(String[] args) {

        Person[] parr = {
          new Person("김길동"),
          new Person("도길동"),
          new Person("한길동")
        };

        Arrays.sort(parr);

        System.out.println(Arrays.toString(parr));
    }
}