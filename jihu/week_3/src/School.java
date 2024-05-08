import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class School {

    public static final int math = 4;
    public static final int korean = 5;
    public static final int out = 3;
    String[] subject = {"국어", "수학"};
    String[] token;
    int i = 0;
    int subjectID = korean;
    static ArrayList<Student> studentList = new ArrayList<Student>();

    School (String infoFileName) throws FileNotFoundException {
        File file = new File(infoFileName); // 파일 객체 생성
        readFile(file);
    }

    public void readFile(File file) throws FileNotFoundException { // 학생 정보가 담겨있는 파일을 입력 받는다
        if (!file.exists()) { // 파일이 존재하지 않는 경우
            System.out.println("읽을 파일이 없습니다.");
            return;
        }
        Scanner input = new Scanner(file);

        while (input.hasNext()) { // 다음 줄이 있는 경우 반복문 실행
            String infoLine = input.nextLine(); // 한 줄씩 읽는다

            if (infoLine != null) {
                token = infoLine.split(",");
                Student newStudent = new Student(token);
                studentList.add(newStudent);
            }
        }
    }
    public void printResult() { // 과목 별로 학생들의 점수와 학점을 출력한다.
        while (subjectID != out) {
            System.out.println("--------------------------");
            System.out.println("     " + subject[i] + " 수강생 학점");
            System.out.println("이름 | 학번 | 중점과목 | 점수");
            System.out.println("--------------------------");
            for (Student info : studentList) {
                System.out.print(info.name + "  " + info.studentID + "  " + info.keySubject + "  ");
                for (Subject infoScore : info.scoreList) {
                    if (subjectID == infoScore.subjectID) {
                        System.out.println(infoScore.score + ":" + infoScore.value);
                    }
                }
            }
            subjectID--;
            i++;
        }
    }
}
