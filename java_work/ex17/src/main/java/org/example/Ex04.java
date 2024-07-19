package org.example;

import org.example.box.Box;
import org.example.box.Goldbox;
import org.example.box.Paperbox;

public class Ex04 {

    public static void main(String[] args) {
        Box box1 = new Box();
        Paperbox box2 = new Paperbox();
        Goldbox box3 = new Goldbox();

        wrapBox(box1);
        wrapBox(box2);
        wrapBox(box3);

    }

    private static void wrapBox(Box box) {
        if(box instanceof Goldbox) {
            ((Goldbox) box).goldbox();
        }
        else if (box instanceof Paperbox) {
            ((Paperbox)box).paperbox();
        }
        else
            box.box();
    }
}
