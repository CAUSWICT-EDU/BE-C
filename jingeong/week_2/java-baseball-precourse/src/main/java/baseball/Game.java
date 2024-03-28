package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private int round; // 회차
    private int strike;
    private int ball;
    public boolean endFlag; // 재시작 or 종료 플래그

    private static Game game = new Game(); // 싱글톤 패턴

    private List<Integer> answer;
    private List<Integer> input;

    private int[] check;

    public Game() {
        gameInit(); // 새로운 판이 시작 됐을 때 기본 설정
    }

    public static Game getInstance() { // 판이 재시작 됐을 때, 기존 객체 재사용 가능
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private void gameInit() {
        round = 1;
        answer = Computer.getInstance().makeRandomNumber();

        System.out.println(answer); // 난수 확인용

        playGame();
    }

    private void setInput() {
        System.out.println("\n숫자를 입력해주세요 : ");
        input = User.getInstance().enterUserInput();
    }


    private void playGame() {
        // 라운드를 진행하는 함수

        while(round < 10){
            setInput(); // 입력 받기

            endFlag = false;
            strike = 0;
            ball = 0;
            // 매 라운드 초기화

            checkAnswer(strike, ball); // strike, ball 개수 체크
            printResult(); // 개수에 따라 결과 출력

            if (endFlag) { // 3 strike시 endFlag 변경 => 해당 판 종료
                restartGame();
                break;
            }

            round ++;
        }

        if (round == 10) {
            System.out.println("정답을 맞추지 못하였습니다. 게임 종료\n"
                    + "정답은 " + answer.get(0) + "" + answer.get(1) + "" + answer.get(2) + "\n");

            restartGame();
        }
    }

    private void checkAnswer(int strike, int ball) {
        // 각 라운드마다 결과를 체크해주는 함수

        for (int i = 0; i < 3; i++) {
            if(input.get(i).equals(answer.get(i))){
                // 기존 정답과 수, 자리 일치하면 strike
                strike++;
            } else {
                if(answer.contains(input.get(i))){  // 이것도 indent 3으로 치는걸까..
                    // 자리는 일치 하지 않으나, 그 수가 포함 되어 있으면 ball
                    ball++;
                }
            }
        }

        this.strike = strike;
        this.ball = ball;
    }

    private void printResult() {
        // 각 라운드마다 결과를 출력해주는 함수

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endFlag = true;
        } else {
            System.out.println(ball + "볼 " + strike +"스트라이크");
        }
    }


    public void restartGame() {
        // 맞췄거나, 기회 9번을 모두 사용했을 때 호출됨

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (Console.readLine().equals("1")) {
            Game.getInstance().gameInit();
        } else {
            game = null; // 객체 삭제
        }
    }
}
