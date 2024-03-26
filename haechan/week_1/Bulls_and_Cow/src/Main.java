import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Main {

    public static void main(String[] args) {
        // 게임 설정 변수
        int N; // 숫자야구 자릿수
        int Cnt = 0; // 시도 횟수

        // 게임시작
        System.out.println("숫자야구게임을 시작합니다. \n자릿수(1~9)를 입력하거나 0을 입력하여 종료하세요.");

        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                N = sc.nextInt();
                if (1 <= N && N <= 9) { //정상적인 입력
                    System.out.println(N + "자리 숫자야구게임을 시작합니다.");
                    System.out.println("____________________________________");
                    break;
                } else if (N == 0) { // 게임종료
                    System.out.println("게임을 종료합니다.");
                } else { // 범위를 벗어난 입력
                    System.out.println("1~9사이의 수를 입력해주세요");
                }
            } catch (Exception e) { // 예외(String 입력이 들어왔을 경우 등)
                System.out.println("올바르지 않은 입력입니다. 다시 작성해주세요.");
            }
        }

        // 게임 숫자 생성
        ArrayList<Integer> random_list = new ArrayList<Integer>(); // 랜덤숫자 배열(정답ㅑㄹ)
        new Random().ints(1, 10).distinct().limit(N).forEach(i -> random_list.add(i));


        // 숫자야구 반복시작
        while (true) {
            int S = 0, B = 0;
            ArrayList<Integer> input_list = new ArrayList<Integer>(); // 입력숫자 배열
            Scanner sc = new Scanner(System.in);
            String str = sc.next();

            try {
                // 게임종료
                if (Integer.parseInt(str) == 0) {
                    System.out.println("게임을 종료합니다.");
                }

                // 입력 자릿수 체크
                if (str.length() != N) {
                    System.out.println(N + "자릿수를 입력해주세요.");
                    continue;
                }

                // 스트링 -> 정수 배열로 변환
                boolean isZero = false;
                for (int i = 0; i < N; i++) {
                    // 0이 입력값에 포함되었을때 예외처리
                    if (str.charAt(i) == '0') {
                        System.out.println("입력값에는 0이 포함될 수 없습니다.");
                        isZero = true;
                        break;
                    } else {
                        input_list.add(str.charAt(i) - '0');
                    }
                }
                if (isZero) continue;

                // 중복입력값 체크
                Set<Integer> set = new HashSet<Integer>(input_list);
                if (input_list.size() != set.size()) {
                    System.out.println("입력값은 다른 숫자로 이루어져야 합니다.");
                    continue;
                }
            }
            catch (Exception e) {
                    // 입력한 값이 숫자가 아닐때 오류처리
                    System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
                    continue;
            }


            Cnt++; // 시도횟수 추가

            /*
            // 디버깅
            for (int i = 0; i < random_list.size(); i++) System.out.print(random_list.get(i) + " ");
            System.out.println();
            for (int i = 0; i < input_list.size(); i++) System.out.print(input_list.get(i) + " ");
            System.out.println();
            */

            // 스트라이크&볼 체크
            for (int i = 0; i < N; i++) {
                if (random_list.get(i) == input_list.get(i)) S++; //스트라이크 판정
                else {
                    for (int j = 0; j < N; j++)
                        if (input_list.get(i) == random_list.get(j)) B++; // 볼 판정
                }
            }

            // 출력
            if (S == 0 && B == 0) System.out.println("OUT");
            else if (S != N) System.out.println(S + "S " + B + "B");
            else {
                System.out.println("정답입니다. " + Cnt + "번 만에 맞추었습니다.");
                break;
            }
        }
    }
}