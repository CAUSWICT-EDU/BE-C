public class Score {
    int score;
    String grade;
    String studentId;
    Subject subject;

    public Score(String studentId, int score, Subject subject){
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public String toString(){
        return "학번 :" + studentId + "," + subject.getSubjectName() + ":" + score;
    }


}
