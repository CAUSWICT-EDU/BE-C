import java.util.ArrayList;
public class Subject {
    private String subjectName;
    private ArrayList<Student> subjectStudents = new ArrayList<>();

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        School.subjects.add(this);
    }

    public void addSubjectStudents(Student student){
        subjectStudents.add(student);
    }

    public void evaluGrade(){
        BasicEvaluation basicEvaluator = new BasicEvaluation();
        RequiredEvaluation requiredEvaluator=new RequiredEvaluation();
        for(Student student:subjectStudents){
            if(student.getStudentMajor().getRequiredSubject().equals(this)){
                for (Grade grade : student.getGradeList()) {
                    if (grade.getSubject().equals(this)) { // 이 과목에 대한 성적인지 확인
                        String evaluatedGrade = requiredEvaluator.getGrade(grade.getScore()); // 성적 평가
                        grade.setGrade(evaluatedGrade); // 평가된 성적 설정
                    }
                }
            }
            else{
                for (Grade grade : student.getGradeList()) {
                    if (grade.getSubject().equals(this)) { // 이 과목에 대한 성적인지 확인
                        String evaluatedGrade = basicEvaluator.getGrade(grade.getScore()); // 성적 평가
                        grade.setGrade(evaluatedGrade); // 평가된 성적 설정
                    }
                }
            }
        }
    }

    public ArrayList<Student> getSubjectStudents() {
        return subjectStudents;
    }
}
