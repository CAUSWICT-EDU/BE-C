import java.io.FileNotFoundException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();

        Input input = new Input();
        Report report = new Report();
        System.out.println(report.gradeReport(input.parsing("C:\\Users\\정세린\\OneDrive\\바탕 화면\\2024_ICT_EDU\\BE-C\\serin\\week_3\\score\\src\\gradeInput.txt")));

    }
}
