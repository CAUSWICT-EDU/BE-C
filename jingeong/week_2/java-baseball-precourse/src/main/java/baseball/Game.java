package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private int round = 1;

    private static Game game;
    private final Computer computer = new Computer();
    private final User user = new User();

    private List<Integer> answer;
    private List<Integer> input;

    private int[] check = new int[2];

    public Game() throws IllegalStateException {
        answer = computer.makeRandomNumber();
        input = changeStringToInteger(user.enterUserInput());

        playGame();
    }

    public static Game getInstance() {
        return game;
    }

    private void playGame() {
        // 라운드를 진행하는 함수

        while(round < 10){
            int strike = 0;
            int ball = 0;
            // 매 라운드 초기화

            checkAnswer();

            strike = check[0];
            ball = check[1];

            printResult(strike, ball);

            round ++;
        }

        System.out.println("정답을 맞추지 못하였습니다. 게임 종료\n" + "정답은 " + answer + "\n");
        restartGame();
    }

    private void checkAnswer() {
        // 각 라운드마다 결과를 체크해주는 함수
        for (int i = 0; i < 3; i++) {
            if(input.get(i).equals(answer.get(i))){
                // 기존 정답과 수, 자리 일치하면 strike
                check[0]++;
            } else if(answer.contains(input.get(i))){
                // 자리는 일치 하지 않으나, 그 수가 포함 되어 있으면 ball
                check[1]++;
            }
        }
    }

    private void printResult(int strike, int ball) {
        // 각 라운드마다 결과를 출력해주는 함수

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restartGame();
        } else {
            System.out.println(ball + "볼 " + strike +"스트라이크");
        }
    }

    public ArrayList<Integer> changeStringToInteger(String[] arr) {
        // 숫자 정수 변환 함수

        ArrayList<Integer> arrayInteger = new ArrayList<>();

        arrayInteger.add(Integer.parseInt(arr[0]));
        arrayInteger.add(Integer.parseInt(arr[1]));
        arrayInteger.add(Integer.parseInt(arr[2]));

        return arrayInteger;
    }

    private void restartGame() {
        // 맞췄거나, 기회 9번을 모두 사용했을 때 호출됨
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (Console.readLine().equals("1")) {
            game = new Game();
        }

    }

}
