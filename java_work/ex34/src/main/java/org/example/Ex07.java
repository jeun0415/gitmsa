package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {

    public static void main(String[] args) throws IOException {

        // 가상의 경로만 만드는 것이어서 cc 파일이 만들어지지 않음
        Path path = Paths.get("cc");

        // 이렇게 하면 cc 파일 만들어짐
//        Files.createFile(path);


        // 10 유니코드 변환하면 줄바꿈
        // 65 유니코드 변환하면 A
        // 이렇게 하면 cc 파일 만들어짐, NIO java 기법
        try(DataOutputStream outputStream = new DataOutputStream(Files.newOutputStream(path))) {
//            outputStream.write(10);
//            outputStream.write(65);
//            outputStream.write(10);
//            outputStream.write(65);
        }catch (Exception e){
            e.printStackTrace();
        }

        // IO java 기법
//        try(OutputStream outputStream = new BufferedOutputStream(
//                new FileOutputStream("aa")
//        )) {
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
