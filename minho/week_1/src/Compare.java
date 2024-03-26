import java.util.List;

public class Compare {
    int strike;
    int ball;

    public int judgestrike(int[] human, List<Integer> computer) {
        strike = 0;
        for (int i = 0; i < 3; i++) {
            if (human[i] == computer.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int judgeball(int[] human, List<Integer> computer) {
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (human[i] == computer.get(j) && i != j) {
                    ball += 1;
                }
            }
        }
        return ball;
    }
}
