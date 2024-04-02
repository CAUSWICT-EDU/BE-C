package baseball;

public class GameMaster {

  private static GameMaster GM = new GameMaster(); //GM은 하나만 존재해야 하기에 static으로 선언

  private GameMaster() {  //외부에서의 객체 생성을 막는다
  }

  public static GameMaster getGM() {  //외부에서 getGM을 통해 GM을 반환
    return GM;
  }

  void judgeEnding(int trigger, NumBaseBall NB) {
    switch (trigger) {
      case 1:
        NB = new NumBaseBall(); //생성자에 숫자 세팅이 달려있음, 숫자 갱신
        break;
      case 2:
        System.exit(0);
        break;
    }
  }


}
