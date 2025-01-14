package org.example.member;

import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Member {

    private int idx;
    private String name;
    private String email;
    private int age;
    private String password;
    private LocalDateTime regdate;
    private LocalDateTime mydate;

    @Override
    public String toString() {
        String temp = mydate==null? "" : DateTimeFormatter.ofPattern("yyyy/mm/dd").format(mydate);
        return "Member{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                ", mydate=" + temp +
                '}';
    }
}
