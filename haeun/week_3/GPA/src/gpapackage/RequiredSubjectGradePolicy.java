package gpapackage;

public class RequiredSubjectGradePolicy implements GradePolicy {
  @Override
  public String calculateGrade(int score) {
    if (score >= 95) {
      return "S";
    } else if (score >= 90) {
      return "A";
    } else if (score >= 80) {
      return "B";
    } else if (score >= 70) {
      return "C";
    } else if (score >= 60) {
      return "D";
    } else {
      return "F";
    }
  }
}
