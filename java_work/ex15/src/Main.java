import java.util.Arrays;

class Main{
    public static void main(String[] args) {

        String str = "Hello.java";
        String temp[] = str.split("\\.");

        System.out.println(temp[0]);
        System.out.println(temp[1]);

        str = "Hello.Java";
        temp = str.split("[A-Z]");
        System.out.println(Arrays.toString(temp));

        str = "안녕하세요1음...2특별히만들려고3하는건4없어요..";
        temp = str.split("\\d");

        System.out.println(Arrays.toString(temp));

        str = "안녕하세요1음...2특별히만들려고3하는건4없어요..";
        temp = str.split("\\D");
        System.out.println(Arrays.toString(temp));



    }
}

// 파일 업로드시에 exe 파일을 올릴 수 없도록 검사 할 때 사용
// Untitled pattern 홈페이지에서 정규표현식 찾아볼 수 있음 ex) regex 사용법