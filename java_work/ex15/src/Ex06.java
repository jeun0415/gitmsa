public class Ex06 {

    public static void main(String[] args) {

        String a = "asd";
        String b = "bsd";

        System.out.println(a+b);
        System.out.println(a.concat(b));

        System.out.println();

        // 사전편찬순으로 비교해서 값 출력
        System.out.println(a.compareTo("asd"));
        System.out.println(a.compareTo("ASD"));
        System.out.println(a.compareTo("qweqwe"));

        System.out.println();

        System.out.println(a.compareToIgnoreCase("ASD"));
        System.out.println(a.compareToIgnoreCase("Asd"));

        System.out.println();

        System.out.println(a.compareToIgnoreCase("ASda"));
        System.out.println(a.compareToIgnoreCase("Asdaqwe"));
        System.out.println(a.compareToIgnoreCase("qweqwedaqwe"));


    }
}
