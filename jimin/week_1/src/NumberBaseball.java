import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
// 원래는 와일드카드 임포트를 했는데 다른 분들 코드 리뷰를 보고 더 적절하게 수정했습니다

public class NumberBaseball {
    private static final Scanner scan = new Scanner(System.in);
    // 클래스 "Scanner"를 변수 "scan"으로써 불러옴 (파이썬의 "import Sth as sth" 과 동일)

    // 난이도 설정과 리겜 설정
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작하겠습니다.\n");

        while (true) {
            System.out.println("1 = Normal");
            System.out.println("2 = Hard");
            System.out.println("3 = Extreme\n");
            System.out.println("\n플레이할 난이도를 정수로 입력해주세요.\n플레이할 난이도:"); // 난이도를 정수로 입력하도록 유도

            int choice = scan.nextInt();
            scan.nextLine(); // 사용자가 "Enter"를 누르면 버퍼에 눈에 보이지 않는 \n이 남기 때문에 이를 없애는 과정

            switch (choice) { //각각의 변수를 인수로 넣어 "PlayGame" 함수 호출 (=게임실행)
                case 1:
                    playGame(3, false, false, 9);
                    break;
                case 2:
                    playGame(4, true, false, 9);
                    break;
                case 3:
                    playGame(4, true, true, 7);
                    break;
                default:
                    System.out.println("난이도는 반드시 정수로 입력해야 합니다."); //사용자의 입력이 정수가 아닌 경우 처리
            }

            // 게임 종료 여부 확인
            System.out.print("다시 한 번 플레이하시겠습니까? (y/n)");
            String play_Again = scan.nextLine().toLowerCase(); //사용자가 대문자로 입력할 수도 있어서 모두 소문자로 변환
            if (play_Again.equals("n")) { //응답이 "n"이 아닌 경우 "while"로 돌아가 게임을 재실행
                break; //응답이 "n"인 경우 프로세스 종료
            }
        }

        scan.close();
    }

    // 게임 플레이의 메인이 되는 함수 정의
    private static void playGame(int numDigits, boolean allowLeadingZero, boolean allowDuplicates, int maxAttempts) {
        System.out.println("\n게임을 시작합니다");

        // 정답 숫자 생성
        String secretNumber = generate_SecretNumber(numDigits, allowLeadingZero, allowDuplicates);

        // 플레이어에게 게임룰 간단 설명
        System.out.println("당신은 " + numDigits + "자리 숫자를 추론해야 합니다");
        System.out.println("당신은 " + maxAttempts + "번의 이닝(시도 기회)가 있습니다");

        // 게임 반복, "attempt"가 "maxAttempts"를 초과하지 않는 경우에만 실행, 초과하는 경우 "for"문을 스킵
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("\n#" + attempt + "이닝");
            System.out.print("숫자를 입력하세요: ");
            String guess = scan.nextLine();

            // 스트라이크와 볼 계산 및 출력
            String result = calculate_Result(secretNumber, guess);
            System.out.println("결과 : " + result);

            // 정답 숫자를 맞춘 경우 처리
            if (result.equals(numDigits + "스트라이크 0볼")) {
                System.out.println("정답입니다! " + attempt + "이닝만에 게임을 승리했습니다");
                return;
            }
        }

        // 모든 이닝을 사용하고도 답을 맞추지 못한 경우 처리
        System.out.println("패배했습니다! 정답 숫자는 다음과 같습니다 : " + secretNumber);
    }

    // 정답 숫자 생성 함수 정의
    private static String generate_SecretNumber(int numDigits, boolean allowLeadingZero, boolean allowDuplicates) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = allowLeadingZero ? 0 : 1; i <= 9; i++) { //첫번째 자리에 0이 올 수 있는지 없는지 여부에 따라 시작점을 0 혹은 1로 설정
            //"조건식? 참일때의 값 : 거짓일때의 값"의 형식으로 작성
            //이 코드에서는 참일 때 i를 0으로, 거짓일 때 i를 1로 한다

            numbers.add(i);
            //시작 지점부터 9까지의 숫자를 "numbers"리스트에 추가
        }

        Collections.shuffle(numbers); //리스트의 숫자 순서를 랜덤으로 섞기

        StringBuilder secretNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numDigits; i++) { //자릿수만큼의 숫자를 리스트 중 임의의 인덱스에 작성
            int index = random.nextInt(numbers.size());
            secretNumber.append(numbers.get(index));
            if (!allowDuplicates) { //중복 불허용인 경우 리스트에서 이미 사용한 숫자를 삭제
                numbers.remove(index);
            }
        }

        return secretNumber.toString();
    }

    // 결과 계산
    private static String calculate_Result(String secretNumber, String guess) {
        int numDigits = secretNumber.length(); //자릿수 설정
        int numStrikes = 0;
        int numBalls = 0;

        for (int i = 0; i < numDigits; i++) { //각 자릿수마다 한자리씩 대조하면서 스트라이크와 볼 개수를 세기
            char secretDigit = secretNumber.charAt(i);
            char guessDigit = guess.charAt(i);

            if (secretDigit == guessDigit) {
                numStrikes++;
            } else if (secretNumber.contains(String.valueOf(guessDigit))) {
                numBalls++;
            }
        }

        return numStrikes + "스트라이크" + " " + numBalls + "볼";
    }
}
