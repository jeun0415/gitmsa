package exam;

/*
1. exam.Student 클래스를 작성하는 연습을 해보도록하자.
exam.Student 클래스에 getTotal() getAverage() 과 를 추가하시오
1. :  getTotal 메서드
기 능 국어 영어 수학 의 점수를 모두 더해서 반환한다 :
(kor), (eng), (math) .
반환타입 : int
        매개변수 없음 :
 */
class Student{
    private float kor;
    private float eng;
    private float math;

    public Student(float kor, float eng, float math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getTotal(){

        int sum = (int)(kor + eng + math);
        return sum;
    }
    public float getAverage(){

        float aver = (kor + eng + math)/3;
        return aver;
    }
}

public class Exam1 {

    public static void main(String[] args) {
        Student s = new Student(90,85,70);
        int result1 = s.getTotal();
        float result2 = s.getAverage();

        System.out.println(result1);
        System.out.println(result2);
    }
}
