package grade;

public class nonMajorEval implements GradeEval { //수강 과목이 전공이 아닐때 점수 산출 방식

    @Override
    public String getGrade(int points) {
        String grade;
        if (points >= 90 && points <= 100)
            grade = "A";
        else if (points >= 80)
            grade = "B";
        else if (points >= 70)
            grade = "C";
        else if (points >= 55)
            grade = "D";
        else
            grade = "F";
        return grade;
    }
}
