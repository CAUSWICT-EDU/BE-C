public class generalScoring implements Scoring {
    @Override
    public String getGrade(int score) {
        String grade;
        if (score >= 90 && score <= 100)
            grade = "A";
        else if(score >= 80)
            grade = "B";
        else if(score >= 70)
            grade = "C";
        else if(score >= 55)
            grade = "D";
        else grade = "F";
        return grade;
    }
}
