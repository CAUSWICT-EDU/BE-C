package baseball;

import java.util.List;

public class Game {
    //싱글톤 패턴
    private Game(){}
    private static Game game =new Game();
    public static Game getInstance(){
        if(game==null){
            game=new Game();
        }
        return game;
    }
    int strike;//스트라이크
    int ball;//볼

    public int judgestrike(int[] human, List<Integer> computer) {//스트라이크를 판단
        // List<Integer>을 쓴 이유는 Answer class에서 computer는 정답을 List<Integer>타입으로 받았기 때문
        strike = 0;
        for (int i = 0; i < 3; i++) {
            if (human[i] == computer.get(i)) {
                strike += 1;//순서와 숫자까지 일치하므로 스트라이크
            }
        }
        return strike;
    }

    public int judgeball(int[] human, List<Integer> computer) {
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (human[i] == computer.get(j) && i != j) {//순서가 같지 않으면서, 숫자가 같을때 볼
                    ball += 1;
                }
            }
        }
        return ball;
    }
}
