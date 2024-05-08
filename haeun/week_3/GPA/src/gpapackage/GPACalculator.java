// GPACalculator.java
package gpapackage;

import java.util.List;

public class GPACalculator {
  private StudentList studentList;

  public GPACalculator(StudentList studentList) {
    this.studentList = studentList;
  }

  public void calculateGrades() {
    List<Student> students = studentList.getStudents();
    GradePolicy generalPolicy = new GeneralSubjectGradePolicy();
    GradePolicy requiredPolicy = new RequiredSubjectGradePolicy();

    for (Student student : students) {
      List<Subject> subjects = student.getSubjects();
      for (Subject subject : subjects) {
        String grade;
        if (subject instanceof GeneralSubject) {
          grade = generalPolicy.calculateGrade(subject.getScore());
        } else {
          grade = requiredPolicy.calculateGrade(subject.getScore());
        }
        subject.setGrade(grade);
      }
    }
  }
  public void printReport() {
    List<Student> students = studentList.getStudents();

    System.out.println("국어 수강생 학점");
    System.out.println("이름 : 학번 : 중요과목 : 점수 : 학점");
    System.out.println("---------------------------------------");

    for (Student student : students) {
      List<Subject> subjects = student.getSubjects();
      Subject koreanSubject = null;
      for (Subject subject : subjects) {
        if (subject.getSubjectName().equals("국어")) {
          koreanSubject = subject;
          break;
        }
      }
      if (koreanSubject != null) {
        System.out.printf("%s : %d : %s : %d : %s%n",
            student.getName(), student.getStudentId(), "국어",
            koreanSubject.getScore(), koreanSubject.getGrade());
        System.out.println("---------------------------------------");
      }
    }

    System.out.println();

    System.out.println("수학 수강생 학점");
    System.out.println("이름 : 학번 : 과목 : 점수 : 학점");
    System.out.println("---------------------------------------");

    for (Student student : students) {
      List<Subject> subjects = student.getSubjects();
      Subject mathSubject = null;
      for (Subject subject : subjects) {
        if (subject.getSubjectName().equals("수학")) {
          mathSubject = subject;
          break;
        }
      }
      if (mathSubject != null) {
        System.out.printf("%s : %d : %s : %d : %s%n",
            student.getName(), student.getStudentId(),"수학",
            mathSubject.getScore(), mathSubject.getGrade());
        System.out.println("---------------------------------------");
      }
    }
  }

}