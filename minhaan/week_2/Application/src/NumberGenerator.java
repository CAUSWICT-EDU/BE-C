import java.util.Random;

public class NumberGenerator {
    private int codeLength;

    public NumberGenerator(int codeLength) {
        this.codeLength = codeLength;
    }

    public int[] generateSecretCode() {
        int[] code = new int[codeLength];
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            code[i] = random.nextInt(10); // Generates random digits from 0 to 9
        }
        return code;
    }
}
