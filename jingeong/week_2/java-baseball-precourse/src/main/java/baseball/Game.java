package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int round = 1;

    private Computer computer = new Computer();
    private User user = new User();

    private List<Integer> answer;
    private List<Integer> input;

    private int[] check = new int[2];

    public Game() throws IllegalStateException {
        answer = computer.makeRandomNumber();
        input = changeStringToInteger(user.enterUserInput());

        playGame();
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

        System.out.println(); // 정답 수 출력
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

        System.out.println();


        if (strike == 3) {
            restartGame();
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


    }

}
