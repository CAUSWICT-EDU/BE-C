package baseball;

public class Application {

  public static void main(String[] args) {
    GameMaster GM = GameMaster.getGM(); //게임의 작동을 총괄하는 GM
    NumBaseBall game = new NumBaseBall(); //새 야구게임 생성
    Referee referee = new Referee();  //심판 생성
    while (true) {
      game.newGame(GM, referee); //게임 시작
    }
  }
}
