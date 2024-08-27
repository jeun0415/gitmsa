package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class Ex01 {

    public static void main(String[] args) {

        AA a = new AA();

        a.insert();

        public class AA {


           static void insert() {
                Connection conn = null;
                PreparedStatement pstmt = null;

                try {
                    Class.forName("sadfdsafsdafd");
                    conn = DriverManager.getConnection("주소주소,roott,q비버닙너");
                    pstmt = conn.prepareStatement(명령명령 D_id, D_name, D_addres value(?, ?, ?));

                    pstmt.setInt(1, 1);
                    pstmt.setString(2, "강아지 왜 앉지 않을까");
                    pstmt.setString(3, "수상하게 발만 깎으셨네 ㄷㄷ");

                    pstmt.executeUpdate();

                } catch (
                        Exception e) {
                    e.printStackTrace();
                    System.out.println("오류");
                }


            }

        }
    }
}