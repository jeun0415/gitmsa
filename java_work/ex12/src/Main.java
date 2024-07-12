import aa.Box;

public class Main {
    public static void main(String[] args) {

        // 인스턴스화 메모리 적재됨
        Box abox = new Box("사과");
        Box bbox = new Box();
        Box cbox = new Box("바나나",10);


        System.out.println(abox);
    //  ㄴ System.out.println(abox.toString()); 같음
        System.out.println(bbox);
        System.out.println(cbox);

    }
}