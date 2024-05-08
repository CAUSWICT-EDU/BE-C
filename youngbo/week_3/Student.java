import jdk.jfr.Frequency;

public class Student {
  private String name;
  private int id;
  private String major;
  private String reguiredSubject;
  private int mathScore;
  private int englishScore;

  Student(String name, int id, String major, String reguiredSubject, int mathScore, int englishScore){
    this.name = name;
    this.id = id;
    this.major = major;
    this.reguiredSubject = reguiredSubject;
    this.mathScore = mathScore;
    this.englishScore = englishScore;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }
  public String getMajor(){
    return this.major;
  }
  public String getReguiredSubject(){
    return this.reguiredSubject;
  }
  public int getMathScore(){
    return this.mathScore;
  }

  public int getEnglishScore() {
    return this.englishScore;
  }
}
