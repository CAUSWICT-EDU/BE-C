import java.util.Arrays;

public class Game {
    private static final int CODE_LENGTH = 3;
    private int[] secretCode;
    private Player player;
    private NumberGenerator numberGenerator;
    private GuessChecker guessChecker;

    public Game() {
        numberGenerator = new NumberGenerator(CODE_LENGTH);
        secretCode = numberGenerator.generateSecretCode();
        player = new Player();
        guessChecker = new GuessChecker(secretCode);
    }

    public int getCodeLength() {
        return CODE_LENGTH;
    }

    public void start() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the " + CODE_LENGTH + "-digit number.");

        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            int[] guess = player.takeGuess(this);
            System.out.println("Your guess: " + Arrays.toString(guess));

            if (Arrays.equals(guess, secretCode)) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number: " + Arrays.toString(secretCode));
            } else {
                String feedback = guessChecker.checkGuess(guess);
                System.out.println("Feedback: " + feedback);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
