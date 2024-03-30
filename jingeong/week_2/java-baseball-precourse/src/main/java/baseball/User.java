package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

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
        //String[] userInput;
        List<Integer> userInputInteger = new ArrayList<>();
        List<String> userInput = new ArrayList<>();

        try {
            //userInput = Console.readLine().trim().split(""); // 주어진 라이브러리 import 후 사용
            userInput = Arrays.asList(Console.readLine().trim().split(""));

            userInputInteger.add(Integer.parseInt(userInput.get(0)));
            userInputInteger.add(Integer.parseInt(userInput.get(1)));
            userInputInteger.add(Integer.parseInt(userInput.get(2)));

            if (userInput.size() != 3) {
                throw new IllegalArgumentException("세자리 수 입력");
            } else if (userInput.contains("0")) {
                throw new IllegalArgumentException("범위 1~9");
            } else if (userInput.stream().distinct().count() != 3) {
                throw new IllegalArgumentException("중복 불가");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 입력");
        }
        return userInputInteger;
    }
}
