package org.example.exam;

class HybridCar extends Car{
    int electricGauge;
    super.gasolineGauge;

}

class HybridWaterCar extends HybridCar{
    int waterGauge;

    public void showCurrentGauge(){
        super.gasolineGauge = gasolineGauge;
        super.electricGauge = electricGauge;

        System.out.println("잔여 가솔린 "+gasolineGauge);
        System.out.println("잔여 전기량 "+electricGauge);
        System.out.println("잔여 워터량 "+waterGauge);
    }
}

public class Ex1 {
    public static void main(String[] args) {


    }
}
