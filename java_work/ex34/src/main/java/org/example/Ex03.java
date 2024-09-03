package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex03 {

    public static void main(String[] args) throws IOException {

        // 예외가 발생하면 뒷문장 실행 안함

        // a폴더 밑에 b폴더 밑에 myfile 생성
//        Files.createFile(Paths.get("d:/a/b/myfile"));

//        Files.createFile(Paths.get("d:/a/b/c/myfile"));

        Files.createDirectory(Paths.get("d:/a/bbb"));
    }
}
