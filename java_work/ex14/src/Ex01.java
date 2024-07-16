// Person
class Person{
    private String name;
    private int age;

    public Person(){} // 기본생성자
    public Person(String name) {
        this.name = name; // 다른생성자
    }

    // 행동하는 메서드(함수)
    public void greeting(){
        System.out.println(name+" hello");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// constructor로 private 변수를 바꿀 수 있음
// setter로 private 변수를 바꿀 수 있음
// 다른 생성자 선언 시 기본 생성자 생략 불가
public class Ex01 {

    public static void main(String[] args) {
        // 기본생성자 선언 후에 setter 로 변수 name 변경
        Person p1 = new Person();
        // name을 바꾸는 다른 생성자로 선언
        Person p2 = new Person("박길동");
        p1.setName("홍길동");

        p1.greeting();
        p2.greeting();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getName());

    }
}
