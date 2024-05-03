package baseball;

import java.util.Scanner;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            Games games = new Games(); // 게임 시작
            if (games.play()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else {
                System.out.println("9회차  게임이 모두 끝났습니다. 컴퓨터의 승리입니다.");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = sc.nextInt();
        } while (choice == 1);

        System.out.println("게임 종료");
    }

}

class Computer {

    int[] secretNumber = new int[3];

    int[] makeSecretNumber() { // 난수 생성
        Random random = new Random();

        for (int i=0;i<3;i++) {
            int num;
            boolean same = false;
            num = random.nextInt(9)+1;
            for (int j=0;j<i;j++) {
                if (secretNumber[j] == num) {
                    same = true;
                    i--;
                    break;
                }
            }
            if (!same) {
                secretNumber[i] = num;
            }
        }
        return secretNumber;
    }
}


class User {
    int num = 1;
    int[] input = new int[3];
    boolean same = false;

    int[] guess() { // 사용자에게 숫자를 입력 받는 메소드
        Scanner sc = new Scanner(System.in);

        System.out.println("[" + num + "회차 숫자야구]\n");

        boolean checkinput = false;

        while (!checkinput) { // 숫자 3개를 입력
            System.out.println("숫자를 입력해주세요 : ");
            int userNum = sc.nextInt();

            if (userNum < 100 || userNum > 999) { // 숫자의 범위를 벗어난 경우 예외
                System.out.println("숫자의 범위를 벗어났습니다! 1에서 9까지의 숫자를 다시 입력하세요");
            }
            else {
                checkinput = true;
                for (int i=2;i>=0;i--) {
                    input[i] = userNum % 10;
                    userNum /= 10;
                }
            }
        }

        num++;

        return input;
    }

    boolean duplication() { // 숫자의 중복 입력 예외처리

        if (input[0] == input[1] || input[0] == input[2] || input[1] == input[2]) {
            System.out.println("숫자를 중복되지 않게 입력하세요");
            same = true;
        }

        return same;

    }

}

class Games {
    boolean play() {
        int n = 0; // 생성자
        int[] guessNumber = new int[3];
        int[] madeNumber = new int[3];
        Computer computer = new Computer();
        boolean result = true;

        madeNumber = computer.makeSecretNumber();

        User user = new User();

        while (n < 10) {
            int strike = 0, ball = 0;
            do {
                guessNumber = user.guess();
            }
            while (user.duplication());
            n++;
            for (int i = 0; i < 3; i++) { // 스트라이크 & 볼 비교
                for (int j = 0; j < 3; j++) {
                    if (guessNumber[i] == madeNumber[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            if (strike == 0 && ball == 0) { // 결과 출력
                System.out.println("낫싱");
            } else {
                if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }

            if (strike == 3) { // 게임 성공
                break;
            }
            if (n > 9) { // 게임 실패
                result = false;
            }
        }
        // 9회차까지 반복
        // strike, ball 구분
        return result;
    }
}