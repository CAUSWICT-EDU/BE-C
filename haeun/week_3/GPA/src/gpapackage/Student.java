package gpapackage;
import java.util.ArrayList;
import java.util.List;

public class Student {
  private String name;
  private String major;
  private int studentId;
  private  String requiredSubject;
  private List<Subject> subjects;

  public Student(String name, int studentId, String major) {
    this.name = name;
    this.studentId = studentId;
    this.major = major;
    this.subjects = new ArrayList<>();
  }

  public void addSubject(Subject subject) {
    subjects.add(subject);
  } //어레이리스트 과목 추가

  public String getName() {
    return name;
  }

  public String getMajor() {
    return major;
  }

  public int getStudentId() {
    return studentId;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  @Override
  public String toString() {
    return "이름: " + name + ", 학번: " + studentId + ", 전공: " + major;
  }
}
