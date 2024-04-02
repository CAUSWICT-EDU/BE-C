package baseball;
public class Validate {

    public static boolean isValidate(User user) {
        if (user.getUserInput().size() != 3) {
            return false;
        } else if (user.getUserInput().contains("0")) {
            return false;
        } else return user.getUserInput().stream().distinct().count() == 3;  // 3이면 true 아니면 false;
    }

}
