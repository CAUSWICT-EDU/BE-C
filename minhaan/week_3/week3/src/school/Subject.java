package school;

import java.util.ArrayList;

// 과목 클래스
public class Subject {
    private int subjectID;
    private String subjectName;
    private ArrayList<Student> studentList = new ArrayList<>();

    // 생성자
    public Subject(int subjectID, String subjectName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
    }

    // 과목 ID를 반환하는 메서드
    public int getSubjectID() {
        return subjectID;
    }

    // 과목 이름을 반환하는 메서드
    public String getSubjectName() {
        return subjectName;
    }

    // 학생 목록을 반환하는 메서드
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    // 학생을 학생 목록에 추가하는 메서드
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // 학생을 등록하는 메서드
    public void register(Student student) {
        studentList.add(student);
    }
}
