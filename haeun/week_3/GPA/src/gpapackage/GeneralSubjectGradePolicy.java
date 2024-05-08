package gpapackage;

public class GeneralSubjectGradePolicy implements GradePolicy {
  @Override
  public String calculateGrade(int score) {
    if (score >= 90) {
      return "A";
    } else if (score >= 80) {
      return "B";
    } else if (score >= 70) {
      return "C";
    } else if (score >= 55) {
      return "D";
    } else {
      return "F";
    }
  }
}
