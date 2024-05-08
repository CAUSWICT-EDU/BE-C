public class KeyEvaluation implements Evaluation { // 필수 과목 학점 부여 정책


    public String getValue (int score) { // 점수를 받아 학점을 부여한다
        String value;

        if (score >= 95 && score <= 100)
            value = "S";
        else if (score >= 90)
            value = "A";
        else if (score >= 80)
            value = "B";
        else if (score >= 70)
            value = "C";
        else if (score >= 60)
            value = "D";
        else
            value = "F";
        return value;
    }
}
