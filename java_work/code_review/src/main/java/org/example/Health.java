package org.example;

public class Health {

    private int gender;
    private double height;
    private double weight;

    public Health(int gender, double height, double weight) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public void bmi(){
        double height2 = height/100;
        double bmi = weight/height2/height2;
        System.out.println("BMI : "+bmi);
        if (bmi > 18.5 && bmi < 22.9){
            System.out.println("BMI 정상입니다.");
        } else if (bmi > 22.9) {
            System.out.println("과체중입니다.");
        }
        else {
            System.out.println("저체중입니다.");
        }
    }

    public double averweight(){
        double averweight;
        if (gender == 1){
            averweight = (height/100)*(height/100)*22;
        }
        else {
            averweight = (height/100)*(height/100)*21;
        }

        return averweight;
    }

    public void kcal(){
        double aw = averweight();
        double kcal = aw*35;
        System.out.println("하루 권장 칼로리 : "+kcal+"kcal");

    }
}
