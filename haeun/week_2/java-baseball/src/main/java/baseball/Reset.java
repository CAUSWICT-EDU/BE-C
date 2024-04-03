package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Reset {
  Input Input = new Input();
  CheckAnswer CheckAnswer = new CheckAnswer();
  RandomNumber RandomNumber = new RandomNumber();
  public static int resetVer = 1; //1이면 평범 리셋 0면 게임 종료 리셋

  public void resetting(){
    if( resetVer == 1){
      reset();
    }
    else if(resetVer == 0);{

      int [] retry = retryAnswer();

      if(retry[0] == 0){
        baseball.CheckAnswer.status = 0; //종료
      }
      else if(retry[0]== 1){ // 재시작
        reset();
        int length = baseball.RandomNumber.Ranswer.length; //정답 초기화
        for (int i = 0; i < length; i++) {
          baseball.RandomNumber.Ranswer[i] = 0;
        }
        RandomNumber.realAnswer();
      }
    }
  }
  public int[] retryAnswer(){System.out.println("1이 재시작 0이 종료");
    String in= Console.readLine(); //1이 재시작 0이 종료
    int [] retry= Input.splitStringToArray(in);
    return retry;
  }
public void reset(){

  baseball.CheckAnswer.strikecount = 0;
  baseball.CheckAnswer.ballcount = 0;

  int length = baseball.Input.Uanswer.length;
  for (int i = 0; i < length; i++) { //사용자 배열 초기화
    baseball.Input.Uanswer[i] = 0;
  }
}
}
