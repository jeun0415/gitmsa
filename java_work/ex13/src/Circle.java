class Circle {
    // private 변수는 setter & getter로 참조 가능
    private int rad;
    private String name;

    /* 기본 생성자 생략 가능
    다른 생성자 선언 시 기본생성자 생략 불가
    Alt+Insert 키를 누르면 getter setter constructor 생성 가능
     */

    public Circle(int rad) {
        this.rad = rad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = "홍길동";
            return;
        }
        this.name = name;

    }

    // 이 함수를 통해서만 반지름 넣는 것을 해라
    public void setRad(int r) {
        if (r < 0) {
            rad = 0;
            return;
        }
        rad = r;
    }

    public int getRad() {
        return rad;
    }


    public double getArea() {
        return 3.14 * rad * rad;
    }
}
