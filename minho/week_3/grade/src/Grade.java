public class Grade {
    private Student student;
    private Subject subject;
    private int score;
    private String grade;

    public Grade(Student student,Subject subject,int score){
        this.student=student;
        this.subject=subject;
        this.score=score;
        subject.addSubjectStudents(student);
        student.addStudentGrade(this);
    }

    public int getScore() {
        return score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
