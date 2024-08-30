package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex07 {

    public static void main(String[] args) {

        List<Member> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection
                ("jdbc:mysql://192.168.0.23:3306/aaa","root",
                        "1234")){

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM member ORDER BY IDX DESC");
            ResultSet rs = pstmt.executeQuery();
            // 라이브러리 추가되어 있는지 확인
            while (rs.next()){
                Member member = Member.builder()
                        .name(rs.getString("name"))
                        .idx(rs.getInt("idx"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .regdate(rs.getObject("regdate", LocalDateTime.class))
                        .mydate(rs.getObject("mydate",LocalDateTime.class))
                        .build();
//                Member member = new Member(
//                        rs.getInt("idx"),
//                        rs.getString("name"),
//                        rs.getString("email"),
//                        rs.getInt("age"),
//                        rs.getString("password"),
//                        rs.getObject("regdate",LocalDateTime.class),
//                        rs.getObject("mydate", LocalDateTime.class)
//                );

                list.add(member);
            }
            list.stream().forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
