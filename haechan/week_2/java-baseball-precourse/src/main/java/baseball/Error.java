package baseball;

public class Error {
    static void stingLengthError() {
        System.out.println("입력한 수의 길이가 맞지 않아 종료합니다.");
        System.exit(0);
    }

    static void duplicationError() {
        System.out.println("입력한 수에서 중복 숫자가 포함되었으므로 종료합니다.");
        System.exit(0);
    }
    static void changeIntError() {
        System.out.println("입력한 값이 정수가 아니기에 종료합니다.");
        System.exit(0);
    }
}

