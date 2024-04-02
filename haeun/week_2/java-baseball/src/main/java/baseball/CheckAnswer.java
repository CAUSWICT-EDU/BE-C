package baseball;

public class CheckAnswer {

  Reset Reset = new Reset();

  public static int strikecount = 0;
  public static int ballcount = 0;
  public static int gamecount = 0;
  public static int status = 0;

//  public static void setStrikeCount(int count) {
//    strikecount = count;
//  }
//
//  public static void setBallCount(int count) {
//    ballcount = count;
//  }



  //strike, ball 개수 검사
  public void check() { // 딮 제한으로 바꿔야함
    for (int i = 0; i < 3; i++) {
      if (Input.Uanswer[i] == RandomNumber.Ranswer[i]) {
        strikecount++;
      } else {
        for (int j = 0; j < 3; j++) {
          if (i != j && Input.Uanswer[j] == RandomNumber.Ranswer[i]) {
            ballcount++;
          }
        }
      }
    }
  }
    public void printResult() {

      if (strikecount == 3) {
        System.out.println("게임 성공");

        System.out.printf("정답은 ");
        for (int i = 0; i < 3; i++) {
          System.out.printf("%d", RandomNumber.Ranswer[i]);
        }
        System.out.println("입니다.");
        Reset.reset(1);
      }

      // 게임 결과
      gamecount++;
      System.out.printf("[%d]회차 %d스트라이크 %d볼\n", gamecount, strikecount, ballcount);
      Reset.reset();
    }
  }

