package baseball;

public class Reset {
  Input Input = new Input();
  CheckAnswer CheckAnswer = new CheckAnswer();
  public void reset(){

    baseball.CheckAnswer.strikecount = 0;
    baseball.CheckAnswer.ballcount = 0;

    int length = baseball.Input.Uanswer.length;
    for (int i = 0; i < length; i++) { //사용자 배열 초기화
      baseball.Input.Uanswer[i] = 0;
    }
  }
public void reset(int a){

  baseball.CheckAnswer.strikecount = 0;
  baseball.CheckAnswer.ballcount = 0;
  baseball.CheckAnswer.status = a;

  int length = baseball.Input.Uanswer.length;
  for (int i = 0; i < length; i++) { //사용자 배열 초기화
    baseball.Input.Uanswer[i] = 0;
  }
}
}
