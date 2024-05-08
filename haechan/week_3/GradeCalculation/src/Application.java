import Data.GradeTable;
import Data.StudentTable;
import org.json.simple.parser.ParseException;

import java.io.IOException;
/*
    Application: 전체 프로그램 실행에 관한 클래스
 */
public class Application {
    public static void main(String[] args) throws IOException, ParseException {

        // 필요한 클래스 가져오기
        final Input input = new Input();
        final JudgeGrade judgeGrade = new JudgeGrade();
        final Output output = new Output();

        // 학생 데이터 불러오기
        StudentTable students = input.readCSV("test2.csv");

        // 학점 정책 데이터 불러오기
        GradeTable gradePolicy = input.readPolicy("GradingPolicy.json");

        // 학점 정책 데이터를 바탕으로 학점 판단
        judgeGrade.judge(students, gradePolicy);

        // 결과 출력
        output.printResult(students);
    }
}