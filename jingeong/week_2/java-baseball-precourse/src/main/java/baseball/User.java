package baseball;
import camp.nextstep.edu.missionutils.Console;

public class User {

    public String[] enterUserInput() {
        return Console.readLine().split(""); // 주어진 라이브러리 임포트 후 사용
    }

}
