public class BasicEvaluation implements Evaluation { // 일반 과목 학점 부여 정책


    public String getValue (int score) { // 점수를 받아 학점을 부여한다
        String value;

        if (score >= 90 && score <= 100)
            value = "A";
        else if (score >= 80)
            value = "B";
        else if (score >= 70)
            value = "C";
        else if (score >= 55)
            value = "D";
        else
            value = "F";
        return value;
    }
}
