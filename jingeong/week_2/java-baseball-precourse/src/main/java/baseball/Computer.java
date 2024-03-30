package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Computer {
    private static  Computer computer = new Computer();
    private List<Integer> randomNumber;

    public static Computer getInstance() { // 싱글톤 패턴
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> makeRandomNumber() {
        randomNumber = Arrays.asList(0,0,0);

        while (true) {
            for (int i = 0; i < 3; i++) {
                randomNumber.set(i, Randoms.pickNumberInRange(1,9));
            }
            if (randomNumber.stream().distinct().count() == 3) {
                break;
            }
        }

        return randomNumber;
    }


}
