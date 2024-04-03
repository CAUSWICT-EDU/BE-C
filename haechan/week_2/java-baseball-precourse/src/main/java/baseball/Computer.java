package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Computer {
    ArrayList<Integer> nums = new ArrayList<>(Game.NUMS_SIZE); // 컴퓨터가 정한 3자리 숫자보관

    // 중복이 발생하지 않게 NUMS_SIZE개의 수를 생성
    // LinkedHashSet 중복이 발생하지 않고 순서가 보장되는 List
    void creatRandomNums() {
        LinkedHashSet<Integer> HashSetNums = new LinkedHashSet<>();
        // 중복인 값은 HashSetNums에 저장되지 않으며, NUMS_SIZE개의 수가 저장될떄까지 반복
        while(HashSetNums.size() < Game.NUMS_SIZE) {
            int randomNum = Randoms.pickNumberInRange(1, 9); // (1~9) 사이의 수를 생성
            HashSetNums.add(randomNum);
        }
        this.nums.addAll(HashSetNums); // 선정된 수를 Nums에 추가
    }
}
