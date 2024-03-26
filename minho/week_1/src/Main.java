import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Answer answer = new Answer();
        List<Integer> computerNumber = answer.create();

        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성 한 번만
        Compare compare = new Compare(); // Compare 인스턴스 생성 한 번만

        int[] humanNumber = new int[3]; // 이 위치에 선언하면 변수 스코프 문제 해결
        System.out.println("숫자야구를 시작하겠습니다. 10번까지 시도할수 있습니다.");
        System.out.println("3개의 1~9 사이의 정수를 중복되지 않도록 입력하세요.");

        for(int i = 0; i < 10; i++) {
            System.out.printf("%d번째 시도\n",i+1);

            for(int j = 0; j < humanNumber.length; j++) {
                System.out.printf("%d번째 정수: ", j + 1);
                humanNumber[j] = scanner.nextInt(); // 사용자로부터 정수 입력받기
            }

            System.out.println("strike: " + compare.judgestrike(humanNumber, computerNumber));
            System.out.println("ball: " + compare.judgeball(humanNumber, computerNumber));

            if(compare.judgestrike(humanNumber, computerNumber) == 3) {
                System.out.println("3 스트라이크입니다. 축하합니다!");
                break;
            }
            if(i==9){
                System.out.println("정답을 맞추지 못했습니다.");
            }
        }

        // scanner.close(); 프로그램의 마지막에서 한 번만 닫기
        scanner.close();

        System.out.println("정답: ");

        for (Integer number : computerNumber) {
            System.out.println(number);
        }
    }
}
