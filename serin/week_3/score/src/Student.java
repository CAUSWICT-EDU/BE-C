import java.util.ArrayList;
public class Student {
    private String studentName;
    private Subject required;
    private String studentID;
    private String Major;
    private ArrayList<Score> scoreList = new ArrayList<Score>();


    public Student(String studentName, String studentID, String Major){
        this.studentID = studentID;
        this.studentName = studentName;
        this.Major = Major;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    public String getStudentID(){
        return studentID;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public void setMajor(Subject required) {
        this.required = required;
    }

    public Subject getRequired() {
        return required;
    }

    public void setRequired(Subject required) {
        this.required = required;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }
}
