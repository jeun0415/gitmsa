import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class AA{
    public static BB bb = new BB();
}

class BB{
    public void doA(){
        System.out.println("BB doA");
    }
}

public class Ex07 {

    public static void main(String[] args) {
//        AA.bb.doA();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        // 윈도우 시간을 가져오는 시스템

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }
}
