import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        School mySchool = new School("table.txt"); // 학생 정보가 담긴 파일을 받는다
        mySchool.printResult();
    }
}