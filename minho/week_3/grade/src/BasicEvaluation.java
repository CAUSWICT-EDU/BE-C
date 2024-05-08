public class BasicEvaluation implements Evaluation{
    @Override
    public String getGrade(int score) {
        if(score>=90&&score<=100)
            return "A";
        else if(score>=80)
            return "B";
        else if(score>=70)
            return "C";
        else if(score>=55)
            return "D";
        else
            return "F";
    }
}