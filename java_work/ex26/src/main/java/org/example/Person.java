package org.example;

enum Person {
    MAN(1,"남자"), WOMAN(2,"여자");

    private int num;
    private String gender;

    Person(int num, String gender) {
        this.num = num;
        this.gender = gender;

        System.out.println("호출");
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "num=" + num +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
}


