package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        int check;
        Game game = new Game();
        game.gameInit();
        if (game.gameEnd()) {
            game = null;
        }
    }
}
