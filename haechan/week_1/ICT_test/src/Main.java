import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void GameEnd(String tmp) {
        if (tmp.equals("0")) {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        // 게임 설정 변수
        int N; // 숫자야구 자릿수
        int Cnt = 0;
        ArrayList<Integer> random_list = new ArrayList<Integer>(); // 숫자야구 수
        Scanner sc = new Scanner(System.in);

        // 게임시작
        System.out.println("숫자야구게임을 시작합니다. \n자릿수를 입력하거나 0을 입력하여 종료하세요");
        int str = sc.nextInt();
        GameEnd(str+"");
        N = str;
        System.out.println(N+"자리 숫자야구게임을 시작합니다.");
        System.out.println("____________________________________");

        // 게임 숫자 생성
        for (int i=0; i<N; i++) {
            int tmp = (int) (Math.random()*10);
            random_list.add(tmp);
        }

        // 숫자야구 반복시작
        while(true) {
            ArrayList<Integer> input_list = new ArrayList<Integer>(); // 숫자야구 수
            ArrayList<Integer> num_list = (ArrayList<Integer>) random_list.clone(); // 숫자야구 수
            int S=0, B=0;

            String input = sc.next();
            GameEnd(input);
            if (input.length() != N ) {
                System.out.println("입력자릿수가 맞지 않습니다. 다시 입력해주세요.");
                continue;
            }
            for (int i=0; i<N; i++) {
                input_list.add(input.charAt(i)-'0');
            }
            Cnt++;

            /*
            // 디버깅
            for (int i=0; i<num_list.size(); i++) System.out.print(num_list.get(i)+" ");
            System.out.println();
            for (int i=0; i<input_list.size(); i++) System.out.print(input_list.get(i)+" ");
            System.out.println();
    `        */

            // 스트라이크 체크
            for (int i=0; i<N; i++) {
                if (num_list.get(i) == input_list.get(i)) {
                    num_list.set(i, -1);
                    input_list.set(i, -1);
                    S++;
                }
            }

            // 볼 체크
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    // 다른 위치의 수와 같다면
                    if ( input_list.get(i) == -1 ) break;
                    else if (num_list.get(j) == -1) continue;
                    else if (input_list.get(i) == num_list.get(j) ) {
                        input_list.set(i, -1);
                        num_list.set(j, -1);
                        B++;
                    }
                }
            }

            // 출력
            if (S==0 && B==0) System.out.println("OUT");
            else if (S!=N) System.out.println(S+"S "+B+"B");
            else {
                System.out.println("정답입니다. "+Cnt+"번 만에 맞추었습니다.");
                break;
            }
        }

    }
}