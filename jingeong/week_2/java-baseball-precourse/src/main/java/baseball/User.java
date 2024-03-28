package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class User {
    private static User user = new User();
    private Game game;

    public static User getInstance() { // 싱글톤 패턴
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public List<Integer> enterUserInput() {
        String[] userInput;
        List<Integer> userInputInteger = new ArrayList<>();

        try {
            userInput = Console.readLine().trim().split(""); // 주어진 라이브러리 import 후 사용

            userInputInteger.add(Integer.parseInt(userInput[0]));
            userInputInteger.add(Integer.parseInt(userInput[1]));
            userInputInteger.add(Integer.parseInt(userInput[2]));

            Set<Integer> check = new LinkedHashSet<>(userInputInteger); // 중복 체크

            if (userInput.length != 3) {
                throw new IllegalArgumentException("세자리 수 입력");
            } else if (userInputInteger.contains(0)) {
                throw new IllegalArgumentException("범위 1~9");
            } else if (check.size() < 3) {
                throw new IllegalArgumentException("중복 불가");
            }
        } catch (Throwable t) {
            throw new IllegalArgumentException(t);
        }
        return userInputInteger;
    }
}
