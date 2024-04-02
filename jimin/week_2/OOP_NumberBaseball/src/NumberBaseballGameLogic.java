import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 모두 "private"로 선언
public class NumberBaseballGameLogic {
    private final int numDigits;
    private final boolean allowLeadingZero;
    private final boolean allowDuplicates;
    private final int maxAttempts;
    private final Scanner scan = new Scanner(System.in);


    // "main"에서 받은 파라미터를 변수에 저장
    public NumberBaseballGameLogic(int numDigits, boolean allowLeadingZero, boolean allowDuplicates, int maxAttempts) {
        this.numDigits = numDigits;
        this.allowLeadingZero = allowLeadingZero;
        this.allowDuplicates = allowDuplicates;
        this.maxAttempts = maxAttempts;
        // 파라미터를 통해 받은 인수와 실제 할당하고 싶은 변수 이름이 동일한 경우 "this"를 사용해 구분
    }

    // 게임 루프 및 사용자 상호작용 담당
    public void play() {
        System.out.println("\n게임을 시작합니다");
        String secretNumber = generateSecretNumber();

        System.out.println("당신은 " + numDigits + "자리 숫자를 추론해야 합니다");
        System.out.println("당신은 " + maxAttempts + "번의 이닝(시도 기회)가 있습니다");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("\n#" + attempt + "이닝");

            String guess = getValidGuess();
            // 예외처리 위해 올바른 입력이 수행되었는지 확인

            String result = calculateResult(secretNumber, guess);
            System.out.println("결과 : " + result);

            if (result.equals(numDigits + "스트라이크 0볼")) {
                System.out.println("정답입니다! " + attempt + "이닝만에 게임을 승리했습니다");
                return;
            }
        }

        System.out.println("패배했습니다! 정답 숫자는 다음과 같습니다 : " + secretNumber);
    }


    // 조건에 맞는 랜덤한 정답 숫자를 생성
    private String generateSecretNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = allowLeadingZero ? 0 : 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        StringBuilder secretNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numDigits; i++) {
            int index = random.nextInt(numbers.size());
            secretNumber.append(numbers.get(index));
            if (!allowDuplicates) {
                numbers.remove(index);
            }
        }
        return secretNumber.toString();
    }


    // 입력한 숫자가 유효한 자릿수의 정수인지를 판별하며, 적합한 값이 아닌 경우 예외처리
    private String getValidGuess() {
        String guess;
        while (true) {
            try {
                System.out.print("숫자를 입력하세요: ");
                guess = scan.nextLine();

                if (guess.length() != numDigits) {
                    throw new IllegalArgumentException("답안은 자릿수가 " + numDigits + "개인 정수가 되어야 합니다.");
                }

                for (int i = 0; i < guess.length(); i++) {
                    if (!Character.isDigit(guess.charAt(i))) {
                        throw new IllegalArgumentException("답안은 자릿수가 " + numDigits + "개인 정수가 되어야 합니다.");
                    }
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return guess;
    }

    // 스트라이크 개수와 볼 개수를 연산
    private String calculateResult(String secretNumber, String guess) {
        int numStrikes = 0;
        int numBalls = 0;

        for (int i = 0; i < numDigits; i++) {
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


