import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("* 세 자리수 숫자 야구");
        System.out.println("* 숫자 공백 없이 입력"); // 공백 입력 받으면 여러 조건 처리하는게 더 귀찮아질 것 같아서 그냥 붙임
        System.out.println("* 총 9회차\n");

        int cnt = 1; // 회차

        Random rd = new Random(); // 랜덤 객체

        Set<Integer> set = new LinkedHashSet<>(); // 각 자리수 중복 없이 난수 생성 => 중복 허용 안되는 set 사용
        /* 처음에 그냥 HashSet을 사용했는데, 내부 구조로 인해 정렬아닌 정렬이 되는걸 확인, LinkedHashSet으로 변경 => 뽑히는 순으로 add */

        while(set.size() < 3){
            int random = rd.nextInt(9) + 1; // 1~9
            set.add(random); // 중복 난수가 뽑히면 추가로 더해지지 않으므로, 중복 없는 3자리 수가 될 때까지 루프
        }

        List<Integer> num = new ArrayList<>(set); // set은 get 메소드가 없어서 편의를 위해 변경

        //System.out.println(num); // 난수 확인용


        while (cnt < 10) { // 최대 기회 : 9회

            int strike = 0;
            int ball = 0;

            String[] str; // 입력 받은 수 각 자리별로 분리해서 담으려고 만듦
            /* 공백 포함으로 입력 받으면 굳이 배열 안만들고 StringTokenizer로 받고 바로 넘겨줘도 될 듯 */

            Integer[] guess = new Integer[3]; // 밑에서 set에 넘겨주려고 int[]말고 Integer[]로 함


            System.out.println("Round " + cnt + "."); // 라운드 표시
            System.out.println("enter the number : ");

            while(true) { // 예외처리 => 옳은 입력 들어올 때까지 루프
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    str = br.readLine().split(""); // 입력 값 한자리 씩 string 변경
                    guess[0] = Integer.parseInt(str[0]);
                    guess[1] = Integer.parseInt(str[1]);
                    guess[2] = Integer.parseInt(str[2]);
                    /*
                    왜 굳이 string으로 담고 또 Integer 배열로 옮겼냐면
                    원래 그냥 string으로 받고 밑에 for문에서 정수 변환 했는데,
                    이렇게 하니까 입력 예외처리할 때 "dfae" 같은 진짜 스트링이 들어오는 경우도 생각하다보면 아무튼 복잡해져서
                    exception으로 다 잡으려고 그냥 넣음
                    for문 돌릴까 하다가 3자리라 걍 복붙
                     */

                    Set<Integer> check = new LinkedHashSet<>(Arrays.asList(guess)); // 중복 체크

                    if (str.length > 3) {
                        System.out.println("three - digit is required.");
                    } else if (check.size() < 3) {
                        System.out.println("No duplicates allowed.");
                    } else if (check.contains(0)) { // 숫자 붙여서 받으면 어차피 1224 < 이런건 위에서 잡히기 때문에 0이 있나 없나만 확인해줌
                        System.out.println("bound 1~9");
                    } else break;

                } catch (Exception e) {
                    System.out.println("invaild input");
                }
            }

            for (int i = 0; i < 3; i++) {
                if(guess[i].equals(num.get(i))){ //기존 정답과 수, 자리 일치하면 strike
                    strike++;
                }
                else{
                    if(num.contains(guess[i])){ // 자리는 일치 하지 않으나, 그 수가 포함 되어 있으면 ball
                        ball++;
                    }
                }
            }


            if (strike == 0 && ball == 0) { // 세 자리수를 다 돌았는데, strike도 ball도 없으면 out
                System.out.println("out" + "\n");
            }
            else{
                System.out.println(strike + "S " + ball + "B" + "\n"); // out이 아니라면 그 회차 결과 출력

                if (strike == 3) { // 3 strike == 정답 맞춤 ==> 게임 끝
                    System.out.println("you win!");
                    break;
                }
            }
            cnt++;
        }

        if (cnt == 10) { // 9회차 모두 소진 => 컴퓨터 승
            System.out.println("The game is over.");
            System.out.println("the answer is " + num.get(0)+""+num.get(1)+""+num.get(2));
        }
    }
}

