package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static  Computer computer = new Computer();

    public Computer() {
        makeRandomNumber();
        // Computer instance가 생성되는 동시에 난수 생성 함수 호출
    }

    public static Computer getInstance() { // 싱글톤 패턴
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
        // 주어진 라이브러리 import 후 사용
        // 1부터 9까지 랜덤 숫자 3개 뽑고 return
    }


}
