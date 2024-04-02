package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumBaseBall {

  public int[] compAnswer = new int[3];

  public NumBaseBall() {
    this.setAnswer();
  }

  private void setAnswer() {  //답 생성
    compAnswer[0] = Randoms.pickNumberInRange(1, 9);
    while (compAnswer[0] == compAnswer[1] || compAnswer[1] == compAnswer[2]
        || compAnswer[2] == compAnswer[0]) {
      compAnswer[1] = Randoms.pickNumberInRange(1, 9);
      compAnswer[2] = Randoms.pickNumberInRange(1, 9);
    }
  }

  public void newGame(GameMaster GM, NumBaseBall NB) {  //새 게임 생성
    Referee rf = new Referee();
    rf.receiveAnswer(); //입력 받기
    rf.refineAnswer();  //정제하기
    rf.countResult(this.compAnswer);  //스트라이크, 볼 세기
    rf.printResult(GM, NB); //결과 출력
  }

}
