package org.example.phone;

public class SmartPhone extends MobilePhone {

    private String andtoidVer;

    public SmartPhone(String avar,int number) {
        super(number);
        this.andtoidVer = avar;
    }

    // 재정의
    @Override
    public void  show(){
        super.show();
        System.out.println("androidVer = "+andtoidVer);

    }
}
