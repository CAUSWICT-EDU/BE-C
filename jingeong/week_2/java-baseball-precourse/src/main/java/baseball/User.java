package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {  // 유저는 instance가 여러개인게 맞는거 같아서 싱글톤 제거

    private List<String> userInput;
    private List<Integer> userInputInteger;

    public List<Integer> getUserInputInteger() {
        enterUserInput();
        return userInputInteger;
    }

    public List<String> getUserInput() {
        return userInput;
    }

    private void enterUserInput() {

        userInput = Arrays.asList(Console.readLine().trim().split("")); // 주어진 라이브러리 사용

        if (Validate.isValidate(this)) {
            stringToInteger();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void stringToInteger() {
        userInputInteger = new ArrayList<>();
        try {
            userInputInteger.add(Integer.parseInt(userInput.get(0)));
            userInputInteger.add(Integer.parseInt(userInput.get(1)));
            userInputInteger.add(Integer.parseInt(userInput.get(2)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
