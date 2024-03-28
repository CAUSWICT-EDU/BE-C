package baseball;
import camp.nextstep.edu.missionutils.Console;

public class User {

    public User() {
        enterUserInput(); // User instance가 생성되는 동시에 Input 함수 호출
    }

    public String[] enterUserInput() {
        return Console.readLine().split(""); // 주어진 라이브러리 임포트 후 사용
    }


}
