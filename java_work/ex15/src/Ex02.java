import java.util.Arrays;

// 프로그래머스 문제
public class Ex02 {

    Ex02(){
        System.out.println("여기로 옵니다");
        String result = solution("He11oWor1d","lloWorl",2);
        System.out.println(result);
    }

    public String solution(String my_string,String overwrite_string,int s){
        String answer = "";
        char[] c_my_string = my_string.toCharArray();
        char[] c_overwrite_string = overwrite_string.toCharArray();

        System.out.println(Arrays.toString(c_my_string));
        System.out.println(Arrays.toString(c_overwrite_string));

        System.arraycopy(c_overwrite_string,0,
                c_my_string,s,overwrite_string.length());

        System.out.println(Arrays.toString(c_my_string));
        answer = new String(c_my_string);
        return answer;
    }

    public static void main(String[] args) {
        new Ex02();
    }
}
