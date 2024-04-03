package baseball;

import java.util.ArrayList;

public class GameService {
    int strikeCnt = 0;
    int ballCnt = 0;
    public ArrayList<Integer> randomNums = new ArrayList<>();

     void compareNums(ArrayList<Integer> playerNums, ArrayList<Integer> computerNums) {
        strikeCnt = 0;
        ballCnt = 0;
        for (int i=0; i<Game.NUMS_SIZE; i++) {
            getStrikeCnt(computerNums.get(i), playerNums.get(i));
            getBallCnt(computerNums.get(i), playerNums);
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
    void getBallCnt(Integer computerNum, ArrayList<Integer> playerNums) {
        for (int i=0; i<Game.NUMS_SIZE; i++) {
            Integer playerNum = playerNums.get(i);
            if (computerNum.equals(playerNum)) {
                ballCnt++;
                break;
            }
        }
    }



}
