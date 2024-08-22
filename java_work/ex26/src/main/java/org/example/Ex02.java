package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {

        List<Car> list = Arrays.asList(
                new Car("그랜저",3000),
                new Car("K8",3500),
                new Car("쏘렌토",2200)
        );

        for (Car car : list){
            System.out.println(car);
        }

        System.out.println(list.get(0));    // list 0번째 가져와서 출력

        Collections.sort(list, new Comparator<Car>() {
            @Override       // 이렇게 하면 Car class에서 compareTo정의 안해도 됨
            public int compare(Car o1, Car o2) {
                return o1.getDisp() - o2.getDisp();
            }
        });     // 사용하려면 Comparable 상속받아 compareTo 재정의 해줘야 함

// 람다
//        Collections.sort(list, ((o1, o2) -> o2.getDisp()-o1.getDisp()) );
//        Collections.sort(list, ((o1, o2) -> o2.getName().compareTo(o1.getName()) ));
//        Collections.sort(list, ((o1, o2) -> o1.getName().length()-o2.getName().length()) );

        System.out.println();
        for (Car car : list){
            System.out.println(car);
        }
    }
}
