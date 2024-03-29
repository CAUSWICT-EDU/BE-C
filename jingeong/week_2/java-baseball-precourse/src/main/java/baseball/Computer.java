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

    public List<Integer> makeRandomNumber() {
        while (true) {
            randomNumber = new ArrayList<>();
            Set<Integer> checkDuplicate;
            for (int i = 0; i < 3; i++) {
                randomNumber.add(i, Randoms.pickNumberInRange(1,9));
                //여기서 중복처리 어떻게 할 지 생각해야 될 듯
            }
            checkDuplicate = new LinkedHashSet<>(randomNumber);
            if (randomNumber.size() == checkDuplicate.size()) {
                break;
            }
        }

        return randomNumber;

        //return Randoms.pickUniqueNumbersInRange(1, 9, 3);
        // 주어진 라이브러리 import 후 사용
        // 1부터 9까지 랜덤 숫자 3개 뽑고 return
    }


}
