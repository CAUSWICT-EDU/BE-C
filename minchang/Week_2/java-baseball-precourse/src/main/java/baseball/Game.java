package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    // Singleton
    private  static Game instance;

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

    // Game

    // Field
    boolean isGameSet; // 게임 설정 여부
    int size; // 입력 개수
    int roundCurr; // 게임 진행도
    int roundMax; // 게임 진행 한도

    Player player;
    Computer computer;

    // Struct
    private class Result{
        int strike = 0;
        int ball = 0;
    }

    public void initGame(int size, int round){ // 게임 초기 설정(사이즈 직접 설정)
        this.size = size;
        roundMax = round;
        setGame();
    }

    public void initGame(int size){ // 게임 초기 설정(사이즈 직접 설정)
        this.size = size;
        roundMax = 9;
        setGame();
    }

    private void initGame(){ // 게임 초기 설정(사이즈 자동 설정)
        size = 3;
        roundMax = 9;
        setGame();
    }

    private void setGame(){ // 게임 설정
        roundCurr = 0;
        player = new Player();
        computer = new Computer();
        isGameSet = true;
    }

    private void resetGame(){ // 게임 초기화
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (Console.readLine().equals("1")) {
            setGame();
            startGame();
        } else {
            instance = null; // 객체 삭제
        }
    }

    public void startGame(){ // 게임 시작
        if (!isGameSet)
            return;

        isGameSet = false;

        computer.randNums(size);
        while(true){
            ++roundCurr;

            player.inputNums(size);

            Result result = checkAnswer(player, computer);
            printResult(result);

            if(endGame(result, roundCurr))
                break;
        }

        resetGame();
    }

    private Result checkAnswer(Player player, Computer computer){
        Result result = new Result();
        ArrayList<Integer> playerNums = player.getNums();
        ArrayList<Integer> computerNums = computer.getNums();

        for (int i = 0; i < size; ++i){
            Integer playerNum = playerNums.get(i);
            Integer computerNum = computerNums.get(i);

            if (playerNum.equals(computerNum)) // 컴퓨터의 같은 자리에 같은 수가 있는 경우
                ++result.strike;
            else if(computerNums.stream().anyMatch(num -> num.equals(playerNum))) // 컴퓨터의 수에 있는 경우
                ++result.ball;
        }

        return result;
    }

    private void printResult(Result result){
        if (result.ball > 0){
            System.out.printf("%d볼 \n", result.ball);
        }
        
        if (result.strike > 0){
            System.out.printf("%d스트라이크 \n", result.strike);
        }

        if (result.strike == 0 && result.ball == 0){
            System.out.println("낫싱");
        }
    }

    private boolean endGame(Result result, int roundCurr){
        if (result.strike == size){
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", size);
            return true;
        }
        else if(roundCurr >= roundMax){
            System.out.println("컴퓨터가 승리했습니다! 게임 종료");
            return true;
        }

        return false;
    }
}