package baseball;

import camp.nextstep.edu.missionutils.Console;
import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_it;

import java.util.ArrayList;

public class Player {
    ArrayList<Integer> nums = new ArrayList<>();

    void getUserInput() {
        ArrayList<Integer> playerInputNums = new ArrayList<>();
        String playerInputString = Console.readLine(); // 사용자 입력 받기 (Sting 자료형으로)
        checkStingLength(playerInputString); // 입력한 숫자가 3자리 수인지 확인

        for (int i = 0; i < Game.NUMS_SIZE; i++) {
            char playerNum = playerInputString.charAt(i);
            checkisInt(playerNum);
            playerInputNums.add(i, playerNum - '0');
        }
        nums = playerInputNums;
    }

    void checkStingLength(String playerInputString) {
        if (playerInputString.length() != Game.NUMS_SIZE) {
            Error.stingLengthError();
        }
    }

    void checkisInt(char playerNum) {
        if (playerNum < '1' || playerNum > '9') {
            Error.changeIntError();
        }
        // throw new
    }
}