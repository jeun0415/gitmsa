package org.example;

// comparable compareTo 사용해야 함
// Person 클래스를 배열로 가져오게 되면
public class Person implements Comparable{

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
//        System.out.println("this = "+this);
//        System.out.println("this.age = "+this.age);
//        System.out.println("Person(o) = "+(Person)o);
//        System.out.println(((Person)o).age);


        // 오름차순일 경우, 내림차순으로 하려면 1과 -1을 반대로 적어주면 됨
        // 값은 상관 없이 양수 or 음수만 반환하면 됨
//        if (this.age > ((Person) o).age){
//            return 100;
//        } else if (this.age < ((Person) o).age) {
//            return -100;
//        } else {
//            return 0;
//        }

//        return this.age - ((Person)o).age;
        return ((Person)o).age - this.age;
    }
}
