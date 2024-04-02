import java.util.Random;
import java.util.Scanner;

public class InputAnswer {

  //CheckAnswer CheckAnswer = new CheckAnswer();

  public int[] Uanswer = new int[3];
  public int[] Ranswer = new int[3];

  public boolean samedata(int[] array, int number, int indexN) { // 중복 숫자 검사

    for (int i = 0; i < array.length; i++) {
      if (array[i] == number && i != indexN) {
        return true;
      }
    }
    return false;
  }

  public void real_answer() { //랜덤으로 수 세 개 지정하기 >> 컴퓨터가 만든 진짜 정답
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      Ranswer[i] = random.nextInt(9) + 1;
      if (samedata(Ranswer, Ranswer[i], i)) { // 컴퓨터 입력 중복 방지
        i = i - 2;
      }
    }
  }

  public void user_answer() {  //사용자가 수 세 개 입력하기

    Scanner scanner = new Scanner(System.in);
    System.out.println("한 자리 수 정수를 세 개 입력하세요 (중복 금지)");

    for (int i = 0; i < 3; i++) {
      Uanswer[i] = scanner.nextInt();
      if (Uanswer[i] > 9 || Uanswer[i] == 0) { // 사용자가 범위가 아닌 수를 자리를 입력했을 때
        System.out.println("범위에 맞지 않은 입력입니다. 다시 입력해주세요");
        i--;
      } else if (samedata(Uanswer, Uanswer[i], i)) { // 사용자 입력 중복 검사
        System.out.println("중복된 입력입니다. 다시 입력해주세요");
        i--;
      }
    }

    System.out.printf("입력한 정수는 "); //사용자가 입력받은 수 확인하기 (생략 가능)
    for (int i = 0; i < 3; i++) {
      System.out.printf("%d", Uanswer[i]);
    }
    System.out.println("입니다.");
  }


}
