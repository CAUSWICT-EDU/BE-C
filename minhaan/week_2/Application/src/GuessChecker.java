public class GuessChecker {
    private int[] secretCode;

    public GuessChecker(int[] secretCode) {
        this.secretCode = secretCode;
    }

    public String checkGuess(int[] guess) {
        int correctPositions = 0;
        int correctNumbers = 0;
        int codeLength = secretCode.length;

        for (int i = 0; i < codeLength; i++) {
            if (guess[i] == secretCode[i]) {
                correctPositions++;
            } else {
                for (int j = 0; j < codeLength; j++) {
                    if (guess[i] == secretCode[j]) {
                        correctNumbers++;
                        break;
                    }
                }
            }
        }

        return "Correct positions: " + correctPositions + ", Correct numbers: " + correctNumbers;
    }
}
