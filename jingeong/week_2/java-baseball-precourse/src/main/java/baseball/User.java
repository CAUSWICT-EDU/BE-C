package baseball;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private static User user = new User();

    public static User getInstance() { // 싱글톤 패턴
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public String[] enterUserInput() {
        return Console.readLine().split(""); // 주어진 라이브러리 임포트 후 사용
    }

}
