import java.util.ArrayList;
public class Subject {
    private String subjectName;
    private int subjectId;
    private int gradeType;

    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Subject(String subjectName, int subjectId){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.gradeType = 0; //일반 과목 평가제로 일단 초기화
    }

    public int getSubjectId() {

        return subjectId;
    }

    public void setSubjectId(int subjectId) {

        this.subjectId = subjectId;
    }
    public String getSubjectName(){

        return subjectName;
    }

    public void setSubjectName(String subjectName) {

        this.subjectName = subjectName;
    }


    public ArrayList<Student> getStudentList() {

        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {

        this.studentList = studentList;
    }

    public int getGradeType() {

        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }
    public void addStudent(Student student){
        studentList.add(student);
    }
}
