import java.util.Scanner;

public class NumberBaseballGame {
    private static final Scanner scan = new Scanner(System.in);

    // 사용자가 난이도를 지정하도록 한 후 난이도에 알맞는 상수들을 설정, 입력이 1, 2, 3이 아닌 경우 예외처리
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작하겠습니다.\n");

        while (true) {
            int choice = getDifficultyChoice();

            NumberBaseballGameLogic gameLogic = null;
            switch (choice) {
                case 1:
                    gameLogic = new NumberBaseballGameLogic(3, false, false, 9);
                    break;
                case 2:
                    gameLogic = new NumberBaseballGameLogic(4, true, false, 9);
                    break;
                case 3:
                    gameLogic = new NumberBaseballGameLogic(4, true, true, 7);
                    break;
                default: // 예외처리
                    System.out.println("난이도는 반드시 1, 2, 3 중 하나로 입력해야 합니다.");
            }

            if (gameLogic != null) {
                gameLogic.play();
            }

            System.out.print("다시 한 번 플레이하시겠습니까? (y/n)\n");
            String playAgain = scan.nextLine().toLowerCase();
            if (playAgain.equals("n")) {
                break;
            }
        }

        scan.close();
    }

    private static int getDifficultyChoice() {
        /* 원래 이 객체도 "GameLogic"안에 담으려고 했지만
        "Scanner"를 "Import"하는 과정은 한 번만 일어나는 것이 더 좋을 듯해
        부득이하게 "GameLogic"대신 "Main"아래에 담았습니다
        보통은 어떻게 하는지 모르겠어서 일단 이렇게 둡니다
        조언부탁드립니다
        */
        int choice;
        while (true) {
            try {
                System.out.print("\n플레이할 난이도를 정수로 입력해주세요.\n플레이할 난이도: ");
                choice = scan.nextInt();
                scan.nextLine();
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 입력해주세요.");
                scan.nextLine();
            }
        }
        return choice;
    }
}
