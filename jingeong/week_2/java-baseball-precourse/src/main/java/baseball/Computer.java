package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Computer {
    private static  Computer computer = new Computer();
    public static Computer getInstance() { // 싱글톤 패턴
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> makeRandomNumber() {
        Set<Integer> check = new LinkedHashSet<>();
        List<Integer> randomNumber;


        while (check.size() < 3) {
            check.add(Randoms.pickNumberInRange(1,9));
        }
        randomNumber = new ArrayList<>(check);


        return randomNumber;
    }
}
