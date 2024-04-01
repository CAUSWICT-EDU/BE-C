package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> nums;

    public void randNums(int size){
        ArrayList<Integer> randNums = new ArrayList<>();

        while(randNums.size() < size) {
            int num = Randoms.pickNumberInRange(1, 9); // 1~9까지
            if (!randNums.contains(num)) {
                randNums.add(num);
            }
        }

        nums = randNums;
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }
}
