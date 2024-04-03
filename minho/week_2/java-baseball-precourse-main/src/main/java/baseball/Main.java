package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {//게임을 계속 진행할 상태일지 확인
            Computer computer = Computer.getInstance();//getInstance 메서드를 통해서 Computer class의 유일한 인스턴스값 받아옴
            List<Integer> computerNumber = computer.create();
            Game game = Game.getInstance();//getInstance 메서드를 통해서 Game class의 유일한 인스턴스값 받아옴
            int[] humanNumber = new int[3];//사용자가 입력할 값을 저장할 배열
            System.out.println("숫자야구를 시작하겠습니다. 10번까지 시도할 수 있습니다.");
            System.out.println("3개의 1~9 사이의 정수를 중복되지 않도록 입력하세요.");


            for (int i = 0; i < 10; i++) {//10번의 기회를 줌
                System.out.printf("%d번째 시도\n", i + 1);//현재 시도번호를 사용자에게 알려줌
                for (int j = 0; j < humanNumber.length; j++) {//3개의 숫자를 각각 입력받는다
                    while (true) {//유효한 숫자가 입력될때까지 반복하게 한다.
                        System.out.printf("%d번째 정수: ", j + 1);
                        if (scanner.hasNextInt()) {
                            int input = scanner.nextInt();
                            // 입력된 숫자가 1에서 9 사이에 있고, 이전에 입력된 숫자와 중복되지 않는 경우
                            if (input >= 1 && input <= 9 && !contains(humanNumber, input, j)) {//유효하면 배열에 저장한뒤 루프를 종료함
                                humanNumber[j] = input;
                                break;
                            }
                        } else {//입력이 정수가 아닐경우 입력을 무시
                            scanner.next(); // 입력 무시
                        }
                        System.out.println("1~9 사이의 서로 다른 숫자를 입력해주세요.");
                    }
                }


                int strike = game.judgestrike(humanNumber, computerNumber);//스트라이크 계산
                int ball = game.judgeball(humanNumber, computerNumber);//볼 계산

                //스트라이크와 볼 계산후 출력
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ball == 0) {
                        System.out.print("");
                    } else
                        System.out.print(ball + "볼 ");
                    System.out.println(strike + "스트라이크");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                if (i == 9) {
                    System.out.println("정답을 맞추지 못했습니다.");
                }
            }

            //게임을 계속 진행할지 종료할지 여부 선택
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            while (true) {
                String input = scanner.next();
                if ("1".equals(input)) {
                    keepPlaying = true;
                    break; // 반복문 탈출 후 게임 재시작
                }
                else if ("2".equals(input)) {
                    keepPlaying = false;
                    break; // 반복문 탈출 후 게임 종료
                }
                else {
                    System.out.println("잘못된 입력입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }
        }
        scanner.close();
    }

    private static boolean contains(int[] array, int value, int length) {
        //사용자로부터 3개의 숫자를 입력받을 때, 각 숫자가 서로 다른지 검증하기 위해 필요한 메서드
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
