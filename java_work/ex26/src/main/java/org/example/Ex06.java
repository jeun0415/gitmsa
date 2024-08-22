package org.example;

interface Viewable{
    public void showIt(String str);
}

class Viewer implements Viewable{

    @Override
    public void showIt(String str) {
        System.out.println("str = "+str);
    }
}

public class Ex06 {

    public static void main(String[] args) {
        Viewable viewable = new Viewer();
        viewable.showIt("경고 문구 나올까?");
    }
}
