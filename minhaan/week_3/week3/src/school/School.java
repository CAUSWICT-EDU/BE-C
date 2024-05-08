package school;

import java.util.ArrayList;

// 학교 클래스
public class School {
    private static School instance = new School();
    private static String SCHOOL_NAME = "좋은 학교";
    // 학생 목록
    private ArrayList<Student> studentList = new ArrayList<Student>();
    // 과목 목록
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();

    // 생성자는 외부에서 접근할 수 없도록 private으로 선언
    private School() {}

    // 학교의 인스턴스를 반환하는 정적 메서드
    public static School getInstance() {
        if (instance == null)
            instance = new School();
        return instance;
    }

    // 학생 목록을 반환하는 메서드
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    // 학생을 추가하는 메서드
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // 과목을 추가하는 메서드
    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    // 과목 목록을 반환하는 메서드
    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    // 과목 목록을 설정하는 메서드
    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
