package school;

// 학생의 성적을 나타내는 클래스
public class Score {
    int studentID;
    Subject subject;
    int point;

    // 생성자
    public Score(int studentID, Subject subject, int point) {
        this.studentID = studentID;
        this.subject = subject;
        this.point = point;
    }

    // 학생 ID를 반환하는 메서드
    public int getStudentID() {
        return studentID;
    }

    // 학생 ID를 설정하는 메서드
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // 과목을 반환하는 메서드
    public Subject getSubject() {
        return subject;
    }

    // 과목을 설정하는 메서드
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    // 점수를 반환하는 메서드
    public int getPoint() {
        return point;
    }

    // 점수를 설정하는 메서드
    public void setPoint(int point) {
        this.point = point;
    }

    // 객체를 문자열로 표현하는 메서드
    public String toString() {
        return "studentID" + studentID + "," + subject.getSubjectName() + ":" + point;
    }
}
