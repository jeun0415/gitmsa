package org.example;

import org.example.phone.MobilePhone;
import org.example.phone.SmartPhone;

public class Ex03 {

    public static void main(String[] args) {
        MobilePhone mobilePhone = new SmartPhone("6.0",12345678);
        mobilePhone.show();

    }
}
