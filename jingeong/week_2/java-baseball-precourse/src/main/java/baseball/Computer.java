package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Computer {
    private static  Computer computer = new Computer();
    private List<Integer> randomNumber;
    public static Computer getInstance() { // 싱글톤 패턴
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> getRandomNumber() {
        this.randomNumber = makeRandomNumber();
        return randomNumber; // random number는 public보다 private이 맞는거 같아서 getter 추가
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> randomNumber;
        Set<Integer> check = new LinkedHashSet<>();


        while (check.size() < 3) {
            check.add(Randoms.pickNumberInRange(1,9));
        }
        randomNumber = new ArrayList<>(check);


        return randomNumber;
    }
}