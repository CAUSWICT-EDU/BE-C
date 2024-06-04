package gpapackage;

public class GeneralSubject implements Subject {
  private String subjectName;
  private int score;
  private String grade;

  public GeneralSubject(String subjectName, int score) {
    this.subjectName = subjectName;
    this.score = score;
  }

  @Override
  public String getSubjectName() {
    return subjectName;
  }

  @Override
  public int getScore() {
    return score;
  }

  @Override
  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String getGrade() {
    return grade;
  }

  @Override
  public void setGrade(String grade) {
    this.grade = grade;
  }
}