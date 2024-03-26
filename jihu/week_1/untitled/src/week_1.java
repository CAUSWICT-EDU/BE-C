import java.util.*;

public class week_1 {
    public static void main(String[] args) {
        int[] input = new int[3];
        int num = 1, strike = 0, ball = 0;
        Scanner sc = new Scanner(System.in);
        int[] computer = {1, 2, 3};

        while (strike != 3) { // 숫자 야구 게임 시작
            strike = 0;
            ball = 0;

            System.out.println("["+ num + "회차 숫자야구]\n");
            for (int i=0;i<3;i++) { // 사용자에게 숫자를 3번 입력 받는다
                System.out.println("1에서 9까지의 숫자를 입력하세요 : ");
                input[i] = sc.nextInt();

                if (input[i] < 1 || input[i] > 9) { // 1~9까지의 숫자가 아닌 경우 예외 처리
                    System.out.println("숫자의 범위를 벗어났습니다! 1에서 9까지의 숫자를 다시 입력하세요");
                    break;
                }
            }

            if (input[0] == input[1] || input[0] == input[2] || input[1] == input[2]) { // 중복된 숫자가 있는 경우 예외 처리
                System.out.println("숫자를 중복되지 않게 입력하세요");
            }

            else { // 숫자 야구 strike, ball 구분
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j<3;j++) {
                        if (input[i] == computer[j]) {
                            if (i==j) { // 수와 위치까지 같을 경우
                                strike++;
                            }
                            else { // 수만 같을 경우
                                ball++;
                            }
                        }
                    }
                }

                System.out.println("[결과]스트라이크 : "+ strike + ", 볼 : " + ball + "\n"); // 결과 출력

            }

            num++; //

        }

        System.out.println("정답입니다! 축하합니다!"); // 숫자 야구 끝
    }
}