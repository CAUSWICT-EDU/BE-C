import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // 전공 및 과목 생성
        Subject koreanSubject = new Subject("국어");
        Subject mathSubject = new Subject("수학");

        Major koreanMajor = new Major("국어국문학과", koreanSubject);
        Major computerMajor = new Major("컴퓨터공학과", mathSubject);

        // 학생 생성 및 과목 등록
        Student student1 = new Student("안성원", "181213", koreanMajor);
        Student student2 = new Student("오태훈", "182330", computerMajor);
        Student student3 = new Student("이동호", "171518", koreanMajor);
        Student student4 = new Student("조성욱", "172350", koreanMajor);
        Student student5 = new Student("최태평", "171290", computerMajor);

        // 성적 입력
        new Grade(student1, mathSubject, 95);
        new Grade(student1, koreanSubject, 56);

        new Grade(student2, mathSubject, 95);
        new Grade(student2, koreanSubject, 98);

        new Grade(student3, mathSubject, 100);
        new Grade(student3, koreanSubject, 88);

        new Grade(student4, mathSubject, 89);
        new Grade(student4, koreanSubject, 95);

        new Grade(student5, mathSubject, 83);
        new Grade(student5, koreanSubject, 56);

        // 성적 평가 실행
        koreanSubject.evaluGrade();
        mathSubject.evaluGrade();

        // 결과 출력
        System.out.println("국어 성적표");
        for (Student student : koreanSubject.getSubjectStudents()) {
            for (Grade grade : student.getGradeList()) {
                if (grade.getSubject().equals(koreanSubject)) {
                    System.out.println("이름: " + student.getStudentName() + " | 학번: " + student.getStudentId() + " | 과목: 국어 | 점수: " + grade.getScore() + " | 성적: " + grade.getGrade());
                }
            }
        }

        System.out.println("수학 성적표");
        for (Student student : mathSubject.getSubjectStudents()) {
            for (Grade grade : student.getGradeList()) {
                if (grade.getSubject().equals(mathSubject)) {
                    System.out.println("이름: " + student.getStudentName() + " | 학번: " + student.getStudentId() + " | 과목: 수학 | 점수: " + grade.getScore() + " | 성적: " + grade.getGrade());
                }
            }
        }
    }
}
