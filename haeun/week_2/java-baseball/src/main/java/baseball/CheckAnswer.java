package baseball;

public class CheckAnswer {

  //초기화/**/
  public int strikecount = 0;
  public int ballcount = 0;
  public int gamecount = 1;

  CheckAnswer(){
    this.strikecount;
    this.ballcount;
    this.gamecount;
  }


  //strike, ball 개수 검사
  public void CheckAnswer() {
    for (int i = 0; i < 3; i++) {
      if (Baseball.Uanswer[i] == Baseball.Ranswer[i]) {
        strikecount++;
      } else {
        for (int j = 0; j < 3; j++) {
          if (i != j && Baseball.Uanswer[j] == Baseball.Ranswer[i]) {
            ballcount++;
          }
        }
      }
    }
    public void print() {
      if (strikecount == 3) {
        System.out.println("게임 성공");

        System.out.printf("정답은 ");
        for (int i = 0; i < 3; i++) {
          System.out.printf("%d", Baseball.Ranswer[i]);
        }
        System.out.println("입니다.");
        //break;
      } else if (gamecount >= 9) {
        System.out.println("게임 실패");

        System.out.printf("정답은 ");
        for (int i = 0; i < 3; i++) {
          System.out.printf("%d", Baseball.Ranswer[i]);
        }
        System.out.println("입니다.");
        //break;
      }

      //재시작
      gamecount++;
      for (int i = 0; i < Baseball.Uanswer.length; i++) { //사용자 배열 초기화
        Baseball.Uanswer[i] = 0;
      }

      // 게임 결과
      System.out.printf("[%d]회차 %d스트라이크 %d볼\n", gamecount, strikecount, ballcount);

    }
  }
}
}
