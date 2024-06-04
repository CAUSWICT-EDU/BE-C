import java.util.ArrayList;

public class Student {
    private String studentName;
    private String studentId;
    private Major studentMajor;
    private ArrayList<Grade> gradeList = new ArrayList<>();

    public Student(String studentName,String studentId,Major studentMajor){
        this.studentName=studentName;
        this.studentId=studentId;
        this.studentMajor=studentMajor;
        School.students.add(this);
    }

    public void addStudentGrade(Grade grade){
        gradeList.add(grade);
    }

    public String getStudentName(){
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public Major getStudentMajor() {
        return studentMajor;
    }

    public ArrayList<Grade> getGradeList() {
        return gradeList;
    }
}
