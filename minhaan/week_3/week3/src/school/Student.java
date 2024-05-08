package school;

import java.util.ArrayList;

// 학생 클래스
public class Student {
    private String studentName;
    private int studentID;
    private Subject majorSubject;
    private ArrayList<Score> scoreList = new ArrayList<>();

    // 생성자
    public Student(String studentName, int studentID, Subject majorSubject) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.majorSubject = majorSubject;
    }

    // 성적 추가 메서드
    public void addSubjectScore(Score score) {
        scoreList.add(score);
    }

    // 학생 학번을 반환하는 메서드
    public int getStudentID() {
        return studentID;
    }

    // 학생 학번을 설정하는 메서드
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // 학생 이름을 반환하는 메서드
    public String getStudentName() {
        return studentName;
    }

    // 학생 이름을 설정하는 메서드
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // 전공 과목을 반환하는 메서드
    public Subject getMajorSubject() {
        return majorSubject;
    }

    // 전공 과목을 설정하는 메서드
    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }

    // 성적 목록을 반환하는 메서드
    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    // 성적 목록을 설정하는 메서드
    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    // 성적을 추가하는 메서드
    public void addScore(Score score) {
        scoreList.add(score);
    }
}
