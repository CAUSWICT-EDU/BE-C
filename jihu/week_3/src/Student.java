import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    String name; // 학생 이름
    String studentID; // 학생 학번
    String major; // 학생 전공
    String keySubject; // 학생 필수과목
    int keySubjectID; // 필수과목 ID
    String[] token; // 학생 정보 배열
    ArrayList<Subject> scoreList = new ArrayList<Subject>(); // Subject 객체 배열 (과목별 점수 저장)

    Student(String[] infoStudent) throws FileNotFoundException {

        name = infoStudent[0].trim();
        studentID = infoStudent[1].trim();
        major = infoStudent[2].trim();
        keySubject = infoStudent[3].trim();
        assignSubjectID();

        for (int i = 4; i < infoStudent.length; i++) { // Subject 객체를 생성해서 과목별 점수와 학점을 저장한다.
            Subject subject = new Subject(keySubjectID, infoStudent[i].trim(), i);
            scoreList.add(subject);
        }
    }

    public void assignSubjectID() { // 필수과목에 대한 필수과목 ID 를 할당한다. (코드짜기에 용이함)
        if (keySubject.equals("국어")) {
            keySubjectID = School.korean;
        } else {
            keySubjectID = School.math;
        }
    }
}
