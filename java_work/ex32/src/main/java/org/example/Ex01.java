package org.example;

import java.time.LocalDate;

public class Ex01 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        // 달력에 많이 사용 ex) 윤년
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.of(localDate.getYear(),12,25);
        System.out.println(localDate1);

        // 이렇게 바뀐 날짜를 다시 담아주면 날짜 값이 초기화 됨
        localDate1 = localDate1.minusDays(1);
        System.out.println("localDate1.minusDays(1) = "+localDate1.minusDays(1));
        System.out.println("localDate2.plusDays(2) = "+localDate1.plusDays(2));
        // -1일 했다고 해서 원래 값이 초기화 되는 것은 아님

    }
}
