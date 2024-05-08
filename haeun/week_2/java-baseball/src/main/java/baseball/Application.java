package baseball;

public class Application {
  public static void main(String[] args) {
    Input Input = new Input();
    CheckAnswer CheckAnswer = new CheckAnswer();
    RandomNumber RandomNumber = new RandomNumber();
    Reset Reset = new Reset();

    RandomNumber.realAnswer(); // 컴퓨터 정답
    //baseball.CheckAnswer.status = 0;

    System.out.println("게임 시작");
    boolean keep = true;
    while (keep){
      Input.userAnswer();
      CheckAnswer.check();
      CheckAnswer.printResult();
      Reset.resetting();

      if(baseball.CheckAnswer.status==0){
        break;
      }
    }


  }
}
