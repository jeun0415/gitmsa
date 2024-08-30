package org.example;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex05 {

    public static void main(String[] args) {

        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted();
//                .filter(s -> s.contains("Asia"))
//                .forEach(System.out::println);

        // 한국 시간 가지고 오기
        ZonedDateTime korea = ZonedDateTime.now();
        System.out.println(korea);

        ZonedDateTime paris = ZonedDateTime.of(korea.toLocalDateTime(),
                ZoneId.of("Europe/Paris"));
        System.out.println(paris);

        Duration duration = Duration.between(korea,paris);
        System.out.println(duration);
    }
}
