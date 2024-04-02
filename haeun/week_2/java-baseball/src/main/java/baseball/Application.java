package baseball;

public class Application {
  public static void main(String[] args) {
    Input Input = new Input();
    CheckAnswer CheckAnswer = new CheckAnswer();
    RandomNumber RandomNumber = new RandomNumber();
    RandomNumber.realAnswer(); // 컴퓨터 정답

    System.out.println("게임 시작");
    int c = 0;
    while(c<9){
      Input.userAnswer();
      CheckAnswer.check();
      CheckAnswer.printResult();
      c++;
    }
  }
}
