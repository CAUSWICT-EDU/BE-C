
package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

  public static int[] Uanswer = new int[3];

  public boolean samedata(int[] array, int number, int indexN) { // 중복 숫자 검사
    for (int i = 0; i < array.length; i++) {
      if (array[i] == number && i != indexN) {
        return true;
      }
    }
    return false;
  }

  public static int[] splitStringToArray(String input) {
    // 문자열의 길이만큼 배열 생성
    int[] dummy = new int[input.length()];
    // 문자열을 순회하면서 각 문자를 숫자로 변환하여 배열에 저장
    for (int i = 0; i < input.length(); i++) {
      dummy[i] = Character.getNumericValue(input.charAt(i));
    }
    return dummy;
  }

  public void userAnswer() {

    System.out.println("세 자리 정수를 세 개 입력하세요 (중복 금지)");
    String input = Console.readLine();
    Uanswer = splitStringToArray(input);

    for (int i = 0; i < Uanswer.length; i++) { // 문자 입력 방지
      if (Uanswer[i] > 10 || Uanswer[i] < 0) {
        System.out.printf("문자는 잘못된 값입니다.");
        System.exit(0);
      } else if (samedata(Uanswer, Uanswer[i], i)) { // 정수 중복 방지
        System.out.printf("중복은 잘못된 값입니다.");
        System.exit(0);
      } else if (Uanswer.length != 3) {
        System.out.printf("자릿수가 다른 건 잘못된 값입니다."); //자릿수 다른 거 방지
        System.exit(0);
      }
    }
    System.out.print("입력한 정수는 "); //사용자가 입력받은 수 확인하기 (생략 가능)
    for (int i = 0; i < 3; i++) {
      System.out.printf("%d", Uanswer[i]);
    }
    System.out.println("입니다.");
  }
}


