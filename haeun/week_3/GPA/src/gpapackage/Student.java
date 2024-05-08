package gpapackage;
import java.util.ArrayList;
import java.util.List;

//public class Student {
//  String name;
//  String major;
//  int studentid;
//  int mathscore;
//  int koreanscore;
//  String requiredsubject;
//  String koreangpa;
//  String mathgpa;
//  public Student(){ //기본 생성자
//  }
//
//  public void getGeneralGpa(Student student){
//    String gpasubject;
//    int score;
//
//    if(this.requiredsubject == "국어"){
//      gpasubject = this.mathgpa;
//      score = this.mathscore;
//    }
//    else{
//      gpasubject = this.koreangpa;
//      score = this.koreanscore;
//    }
//
//      if(90 <= score){
//        gpasubject= "A";}
//      else if (score < 90 && score >= 80){
//        gpasubject = "B";}
//      else if (score < 80 && score >= 70){
//        gpasubject = "C";}
//      else if (score < 70 && score >= 55){
//        gpasubject = "D";}
//      else if (score < 55){
//        gpasubject = "F";}
//    }
//  public void getRequiredGpa(Student student, int score){
//    String gpasubject = this.requiredsubject;
//    if(95 <= score){
//      gpasubject= "S";}
//    else if (score < 95 && score >= 90){
//      gpasubject = "A";}
//    else if (score < 90 && score >= 80){
//      gpasubject = "B";}
//    else if (score < 80 && score >= 70){
//      gpasubject = "C";}
//    else if (score < 70 && score >= 60){
//      gpasubject = "D";}
//    else if (score < 60){
//      gpasubject = "F";}
//
//    if(this.requiredsubject == "국어"){
//      this.koreangpa = gpasubject;
//    }
//    else{
//      this.mathgpa = gpasubject;
//    }
//  }
//
//
//}

public class Student {
  private String name;
  private String major;
  private int studentId;
  private List<Subject> subjects;

  public Student(String name, int studentId, String major) {
    this.name = name;
    this.studentId = studentId;
    this.major = major;
    this.subjects = new ArrayList<>();
  }

  public void addSubject(Subject subject) {
    subjects.add(subject);
  }

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
