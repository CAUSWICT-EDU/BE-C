package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumBaseBall {

  public int[] compAnswer = new int[3];

  public NumBaseBall() {
    this.setAnswer();
  }

  public void setAnswer() {  //답 생성
    compAnswer[0] = Randoms.pickNumberInRange(1, 9);
    while (compAnswer[0] == compAnswer[1] || compAnswer[1] == compAnswer[2]
        || compAnswer[2] == compAnswer[0]) {
      compAnswer[1] = Randoms.pickNumberInRange(1, 9);
      compAnswer[2] = Randoms.pickNumberInRange(1, 9);
    }
  }

  public int[] getAnswer() {
    return this.compAnswer; //컴퓨터가 정한 답을 반환한다.
  }

  public void newGame(GameMaster GM, Referee RF) {  //새 게임 생성
    RF.receiveAnswer(); //입력 받기
    RF.refineAnswer();  //정제하기
    RF.countResult(getAnswer());  //스트라이크, 볼 세기
    RF.printResult(GM, this); //결과 출력
  }

}
