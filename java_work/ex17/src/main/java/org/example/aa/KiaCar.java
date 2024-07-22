package org.example.aa;

import lombok.ToString;

// @ToString
public class KiaCar extends Car {

    public KiaCar(String name,String desc,String company){
        super.name = name;
        super.desc = desc;
        this.company = company;
    }

    public void show(){
        System.out.println(
                name+" "+
                desc+" "+
                company
        );
    }

    @Override
    public String toString() {
        return "KiaCar{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
