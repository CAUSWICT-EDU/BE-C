import java.util.Scanner;

public class Player {
    private Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public int[] takeGuess(Game game) {
        System.out.print("Enter your guess (" + game.getCodeLength() + " digits): ");
        String input = scanner.nextLine();

        while (!isValidInput(input, game.getCodeLength())) {
            System.out.println("Invalid input. Please enter " + game.getCodeLength() + " digits.");
            System.out.print("Enter your guess (" + game.getCodeLength() + " digits): ");
            input = scanner.nextLine();
        }

        int[] guess = new int[game.getCodeLength()];
        for (int i = 0; i < game.getCodeLength(); i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));
        }

        return guess;
    }

    private boolean isValidInput(String input, int codeLength) {
        if (input.length() != codeLength) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
