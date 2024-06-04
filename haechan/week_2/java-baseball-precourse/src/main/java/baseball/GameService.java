package baseball;

import java.util.ArrayList;

public class GameService {
    int strikeCnt = 0;
    int ballCnt = 0;

    boolean isCorrectNums = false; // 플레이어가 정답을 맞췄는지 확인하는 상태변수

     void compareNums(ArrayList<Integer> playerNums, ArrayList<Integer> computerNums) {
        strikeCnt = 0;
        ballCnt = 0;
        for (int i=0; i<Game.NUMS_SIZE; i++) {
            getStrikeCnt(computerNums.get(i), playerNums.get(i));
            getBallCnt(computerNums, playerNums.get(i), i);
        }
    }

    void printRoundResult() {
        if (ballCnt != 0) {
            System.out.println(ballCnt+"볼");
        }

        if (strikeCnt != 0) {
            System.out.println(strikeCnt+"스트라이크");
        }
        if (strikeCnt==0 && ballCnt==0) {
            System.out.println("낫싱");
        }
    }

    void getStrikeCnt(Integer computerNum, Integer playerNum) {
         if (computerNum.equals(playerNum)) strikeCnt++;
    }
    void getBallCnt(ArrayList<Integer> computerNums, Integer playerNum, int playerNumIdx) {
        for (int i=0; i<Game.NUMS_SIZE; i++) {
            Integer computerNum = computerNums.get(i);
            if (playerNumIdx == i) continue; // 이미 스트라이크 처리를 했다면 볼체크 제외
            if (computerNum.equals(playerNum)) {
                ballCnt++;
                break;
            }
        }
    }
}
