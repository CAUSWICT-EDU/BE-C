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
        Set<Integer> check = new LinkedHashSet<>();

        while (check.size() < 3) {
            check.add(Randoms.pickNumberInRange(1,9));
        }
        randomNumber = new ArrayList<>(check);


        return randomNumber;
    }
}
