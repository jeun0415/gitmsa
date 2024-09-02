package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex04 {
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter("myfile",true));
        // true하면 원래 내용 유지하면서 글 내용 추가함

        bw.write("글자를 바꿀거야");
        bw.newLine();
        bw.write("바꼈나");
        bw.newLine();
        bw.write("고길동, 최포미, 임예서");
        bw.close();

        BufferedReader fr = new BufferedReader(new FileReader("myfile"));

        while (true) {
            String str = fr.readLine();
            System.out.println(str);

            if (str == null)
                break;
        }
        fr.close();
    }
}
