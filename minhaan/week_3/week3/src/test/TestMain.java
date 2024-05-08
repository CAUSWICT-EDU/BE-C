package test;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateReport;
import utils.Define;

// 테스트를 위한 메인 클래스
public class TestMain {
    // 인스턴스 생성
    School goodSchool = School.getInstance();
    Subject korean;
    Subject math;
    // 성적 보고서 생성기
    GenerateReport gradeReport = new GenerateReport();

    // 메인 메서드
    public static void main(String[] args) {
        // 테스트 클래스 인스턴스 생성
        TestMain test = new TestMain();
        test.createSubject();
        test.createStudent();
        // 성적 보고서 생성 및 출력
        String report = test.gradeReport.getReport();
        System.out.println(report);
    }

    // 과목 생성 메서드
    public void createSubject() {
        // 국어 과목 생성 및 학교에 추가
        korean = new Subject(Define.KOREAN, "국어");
        goodSchool.addSubject(korean);
        // 수학 과목 생성 및 학교에 추가
        math = new Subject(Define.MATH, "수학");
        goodSchool.addSubject(math);
    }

    // 학생 생성 메서드
    public void createStudent() {
        // 학생들 생성
        Student student1 = new Student("Alice", 22347, math);
        Student student2 = new Student("Bob", 13878, korean);
        Student student3 = new Student("Charlie", 19487, korean);
        Student student4 = new Student("David", 18982, math);
        Student student5 = new Student("Eve", 23862, korean);

        // 학생들을 학교에 추가
        goodSchool.addStudent(student1); //maybe I couldve used for loop here to simplify?
        goodSchool.addStudent(student2);
        goodSchool.addStudent(student3);
        goodSchool.addStudent(student4);
        goodSchool.addStudent(student5);

        // 각 과목에 학생 등록
        korean.register(student1);
        korean.register(student2);
        korean.register(student3);
        korean.register(student4);
        korean.register(student5);

        math.register(student1);
        math.register(student2);
        math.register(student3);
        math.register(student4);
        math.register(student5);

        // 학생들의 성적 추가
        addScoreForStudent(student1, korean, 99);
        addScoreForStudent(student1, math, 76);

        addScoreForStudent(student2, korean, 29);
        addScoreForStudent(student2, math, 90);

        addScoreForStudent(student3, korean, 100);
        addScoreForStudent(student3, math, 88);

        addScoreForStudent(student4, korean, 87);
        addScoreForStudent(student4, math, 76);

        addScoreForStudent(student5, korean, 91);
        addScoreForStudent(student5, math, 55);
    }

    // 학생의 성적 추가 메서드
    public void addScoreForStudent(Student student, Subject subject, int point) {
        Score score = new Score(student.getStudentID(), subject, point);
        student.addSubjectScore(score);
    }
}
