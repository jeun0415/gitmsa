package org.example;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex03 {

    public static void main(String[] args) {

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
//        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return 0;
//            }
//        });

        TreeSet<Person> treeSet = new TreeSet<>( (o1,o2)->o2.getAge()-o1.getAge() );

        treeSet.add(new Person(19,"임예서"));
        treeSet.add(new Person(1,"임예주"));
        treeSet.add(new Person(5,"임현우"));

        System.out.println(treeSet);
    }
}
