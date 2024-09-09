package com.cew.ex04.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReqDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private int age;

//    @Column(length = 100, unique = true)
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    private LocalDateTime wdate;
}
