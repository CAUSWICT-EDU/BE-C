package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Referee {

  int answerStorage;  //숫자로 변환한 세 자리 수 답을 담아두는 곳
  int strike; //스트라이크  
  int ball; //볼 
  int[] userAnswer = new int[3];  //answerStorage의 숫자를 한 자리씩 쪼개서 담은 배열
  String input; //Console.readLine()으로 입력을 받기 위한 저장소

  public void receiveAnswer() {  //유저에게 값을 입력받음, 올바른 값이라면 결과는 세 자리의 정수, answerStorage에 저장됨.
    System.out.print("숫자를 입력해주세요 : ");
    input = Console.readLine();
    if (input.length() != 3) {  //입력이 3글자가 아니면 오류발생
      throw new IllegalArgumentException("올바른 값을 입력해주세요.\n");
    }
    try {
      answerStorage = Integer.parseInt(input);
    } catch (NumberFormatException e) { //3글자 중 문자가 있다면 오류 발생
      throw new IllegalArgumentException("올바른 값을 입력해주세요.\n");
    }
  }

  public void refineAnswer() {  //답을 정제해 배열에 저장한다
    userAnswer[2] = answerStorage % 10;
    answerStorage /= 10;
    userAnswer[1] = answerStorage % 10;
    answerStorage /= 10;
    userAnswer[0] = answerStorage;

    if (userAnswer[0] == userAnswer[1] || userAnswer[1] == userAnswer[2]  //중복 숫자가 있다면 오류 발생
        || userAnswer[2] == userAnswer[0]) {
      throw new IllegalArgumentException("올바른 값을 입력해주세요.\n");
    }
  }

  public void countResult(int[] compAnswer) { //스트라이크, 볼의 개수를 샌다
    strike = 0;
    ball = 0;
    for (int i = 0; i < 3; i++) {
      if (userAnswer[i] == compAnswer[0] || userAnswer[i] == compAnswer[1]
          || userAnswer[i] == compAnswer[2]) {
        ball++;
      }
    }
    for (int i = 0; i < 3; i++) {
      if (userAnswer[i] == compAnswer[i]) {
        ball--;
        strike++;
      }
    }
  }

  public void printResult(GameMaster GM, NumBaseBall NB) {  //답을 출력한다, 3스트라이크라면 GM.judgeEnding 호출
    if (strike == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      GM.judgeEnding(Integer.parseInt(Console.readLine()), NB);
    } else if (strike > 0 && ball > 0) {
      System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    } else if (strike > 0 && ball == 0) {
      System.out.printf("%d스트라이크\n", strike);
    } else if (strike == 0 && ball > 0) {
      System.out.printf("%d볼\n", ball);
    } else {
      System.out.println("낫싱");
    }
  }
}
