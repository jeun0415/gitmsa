package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBRepository {
    public List<AAA> select(){
        List<AAA> list = new ArrayList<>();
        Connection conn = null; // DB 연결객체
        PreparedStatement pstmt = null; // sql 객체
        ResultSet rs = null; // 반환되는 값 담는 객체
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.23:3306/aaa","root","1234");
            pstmt = conn.prepareStatement("select * from aaa"); // sql작성
            // insert update delete -> executeUpdate();
            rs = pstmt.executeQuery(); // sql실행
            while (rs.next()){
                AAA aaa = new AAA();
                aaa.setAge(rs.getInt("age"));
                aaa.setIdx(rs.getInt("idx"));
                aaa.setEmail(rs.getString("email"));
                aaa.setName(rs.getString("name"));
                aaa.setPassword(rs.getString("password"));
                list.add(aaa);
            }
            return list;

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }
}
