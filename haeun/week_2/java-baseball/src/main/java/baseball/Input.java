
package baseball;

import camp.nextstep.edu.missionutils.Console;

import camp.nextstep.edu.missionutils.Randoms;


public class Input {

  public static string[] Uanswer = new int[3];

  public boolean samedata(int[] array, int number, int indexN) { // 중복 숫자 검사

    for (int i = 0; i < array.length; i++) {
      if (array[i] == number && i != indexN) {
        return true;
      }
    }
    return false;
  }
  public void userAnswer() {  //사용자가 수 세 개 입력하기

    System.out.println("세 자리 정수를 세 개 입력하세요 (중복 금지)");

    for (int i = 0; i < 3; i++) {
      string a = Console.readLine();

      if (this.Uanswer[i] > 9 || this.Uanswer[i] == 0) { // 사용자가 범위가 아닌 수를 자리를 입력했을 때
        System.out.println("범위에 맞지 않은 입력입니다. 다시 입력해주세요");
        i--;
      } else if (samedata(this.Uanswer, this.Uanswer[i], i)) { // 사용자 입력 중복 검사
        System.out.println("중복된 입력입니다. 다시 입력해주세요");
        i--;
      }
    }

    System.out.printf("입력한 정수는 "); //사용자가 입력받은 수 확인하기 (생략 가능)
    for (int i = 0; i < 3; i++) {
      System.out.printf("%d", this.Uanswer[i]);
    }
    System.out.println("입니다.");
  }
}


