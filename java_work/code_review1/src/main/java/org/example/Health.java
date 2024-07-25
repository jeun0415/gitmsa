package org.example;

public class Health {

    private int gender;
    private int age;
    private double height;
    private double weight;

    public Health(int gender, int age, double height, double weight) {
        this.gender = gender;
        this.age = age;
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

    public void akcal(){
        double aw = averweight();
        double kcal = aw*35;
        System.out.println("하루 권장 칼로리 : "+kcal+"kcal");
    }

    public void mykcal(){
        double bmr;
        double kcal;
        if (gender == 1){
            bmr = 66.5+(13.75*weight)+(5.003*height)-(6.755*age);
            kcal = bmr*1.2;
        }
        else {
            bmr = 655.1+(9.563*weight)+(1.850*height)-(4.676*age);
            kcal = bmr*1.2;
        }
        System.out.println("하루 권장 칼로리 : "+kcal+"kcal");
        System.out.println("운동을 하지 않은 경우를 기준으로 계산하였습니다.");
        System.out.println("운동량이 있을 경우 칼로리를 늘려야 합니다.");
    }
}