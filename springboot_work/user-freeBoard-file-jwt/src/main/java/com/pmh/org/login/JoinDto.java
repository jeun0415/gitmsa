package com.pmh.org.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinDto {

    private String name;
    private String email;
    private String password;
    private int age;

}
