import java.util.Scanner;
import java.util.Random;

public class NumberleGame {
    private static final int NUM_DIGITS = 3;
    private static final int MAX_ATTEMPTS = 10;

    private int secretNumber;
    private int[] secretDigits;

    public NumberleGame() {
        generateSecretNumber();
    }

    private void generateSecretNumber() {
        Random rand = new Random();
        secretNumber = rand.nextInt(900) + 100; // Generates a random 3-digit number
        secretDigits = new int[NUM_DIGITS];
        for (int i = 0; i < NUM_DIGITS; i++) {
            secretDigits[i] = secretNumber % 10;
            secretNumber /= 10;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Welcome to Numberle!");
        System.out.println("Guess the 3-digit number.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess < 100 || guess > 999) {
                System.out.println("Please enter a 3-digit number.");
                continue;
            }

            int[] guessDigits = new int[NUM_DIGITS];
            for (int i = 0; i < NUM_DIGITS; i++) {
                guessDigits[i] = guess % 10;
                guess /= 10;
            }

            int correctDigits = 0;
            int correctPositions = 0;

            for (int i = 0; i < NUM_DIGITS; i++) {
                if (guessDigits[i] == secretDigits[i]) {
                    correctPositions++;
                } else {
                    for (int j = 0; j < NUM_DIGITS; j++) {
                        if (guessDigits[i] == secretDigits[j]) {
                            correctDigits++;
                            break;
                        }
                    }
                }
            }

            System.out.println("Result: " + correctPositions + " correct positions, " + correctDigits + " correct digits");

            if (correctPositions == NUM_DIGITS) {
                System.out.println("Congratulations! You've guessed the number.");
                break;
            }

            attempts++;
            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've run out of attempts. The number was: " + secretNumber);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        NumberleGame game = new NumberleGame();
        game.play();
    }
}
