package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

  public static int[] Ranswer = new int[3];

  public boolean samedata(int[] array, int number, int indexN) { // 중복 숫자 검사

    for (int i = 0; i < array.length; i++) {
      if (array[i] == number && i != indexN) {
        return true;
      }
    }
    return false;
  }

  public void realAnswer() { //랜덤으로 수 세 개 지정하기 >> 컴퓨터가 만든 진짜 정답
    for (int i = 0; i < 3; i++) {
      Ranswer[i] = Randoms.pickNumberInRange(1,9);
      if (samedata(Ranswer, Ranswer[i], i)) { // 컴퓨터 입력 중복 방지
        i = i - 2;
      }
    }
  }
}
