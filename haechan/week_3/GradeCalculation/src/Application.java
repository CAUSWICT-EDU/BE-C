import Data.GradeTable;
import Data.StudentTable;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, ParseException {

        final Input input = new Input();
        final JudgeGrade judgeGrade = new JudgeGrade();
        final Output output = new Output();

        StudentTable students = input.readCSV("test2.csv");
        GradeTable gradePolicy = input.readPolicy("GradingPolicy.json");

        judgeGrade.judge(students, gradePolicy);

        output.printResult(students);
    }
}