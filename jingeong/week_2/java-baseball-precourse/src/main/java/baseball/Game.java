package baseball;

import java.util.ArrayList;

public class Game {
    private int round = 1;

    private Computer computer = new Computer();
    private User user = new User();

    private ArrayList<Integer> answer;
    private ArrayList<Integer> input;

    private int[] check = new int[2];



    public Game() {
        answer = changeStringToInteger(computer.makeRandomNumber());
        input = changeStringToInteger(user.enterUserInput());

        playGame();
    }

    private void playGame() {
        // 라운드를 진행하는 함수

        while(round < 10){
            int strike = 0;
            int ball = 0;

            checkAnswer(answer, input);

            strike = check[0];
            ball = check[1];

            printResult(strike, ball);

            round ++;
        }

        System.out.println(); // 정답 수 출력
        restartGame();
    }

    private void checkAnswer(ArrayList<Integer> answer, ArrayList<Integer> input) {
        // 각 라운드마다 결과를 체크해주는 함수

        this.answer = answer;
        this.input = input;

        //정답과 입력 값 비교 후, strike와 ball 개수를 각각 check 배열에 넣기
    }

    private void printResult(int strike, int ball) {
        // 각 라운드마다 결과를 출력해주는 함수

        System.out.println();


        if (strike == 3) {
            restartGame();
        }
    }

    private ArrayList<Integer> changeStringToInteger(String[] arr) {
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
