import java.util.ArrayList;

public class Report {
    private ArrayList<Student> studentList = new ArrayList<>();
    public String gradeReport(ArrayList<Student> studentList){
        ArrayList<String> s = new ArrayList<>();
        int i = 0;
        String totalgrade = "";
        for(Student st : studentList){
            s.add(i,st.getStudentName() + " | " + st.getStudentID() + " | " +
                    st.getRequired().getSubjectName() + " | ");
            if (st.getScoreList().get(0).getSubject().getGradeType()==1){
                //첫번째 과목이 해당 학생의 필수 과목(GradeType이 1)일 경우
                s.set(i,s.get(i) + st.getScoreList().get(0).getScore() + ":" + st.getScoreList().get(0).getGrade());
            }
            else {
                s.set(i, s.get(i) + st.getScoreList().get(1).getScore() + ":" + st.getScoreList().get(1).getGrade());
            }
            s.set(i, s.get(i)+"\n");
            i++;
        }
        for (String line : s){
            totalgrade = totalgrade + line;
        }
        return totalgrade;
    }
}
