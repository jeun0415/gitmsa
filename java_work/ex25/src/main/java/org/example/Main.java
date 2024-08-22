package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    private DBRepository dbRepository = new DBRepository();

    public Main(){
        List<AAA> list = dbRepository.select();
//        System.out.println(list);
        HashSet<AAA> set = new HashSet<>(list);

        list = new ArrayList<>(set);

        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {

        new Main();
    }
}

