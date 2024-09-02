package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws Exception{

        try {
            OutputStream os = new FileOutputStream("date.dat");
            os.write(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        try(InputStream is = new FileInputStream("date.dat")) {
            int dat = is.read();
            System.out.println(dat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}