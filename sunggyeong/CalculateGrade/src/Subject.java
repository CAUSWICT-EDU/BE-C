import java.util.ArrayList;
class Subject {
    private String subjectName;
    private double score;
    private String grade;
    private ArrayList<Student> attendees;

    Subject() {
        attendees = GoodSchool.getStudents();
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setScore(double score) {
        this.score = score;
        setGrade(Double.toString(score));
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getGrade() {
        return grade;
    }

    public double getScore() {
        return score;
    }

    public void setGrade(String score) {
        double num = Double.parseDouble(score);
        for (Student attendee : attendees) {
            if (subjectName.equals(GoodSchool.getRequiredSubject(attendee.getMajor()))) {
                if (num > 100 || num < 0) {
                    throw new IllegalArgumentException();
                } else if (num >= 95) {
                    grade = "S";
                } else if (num >= 90) {
                    grade = "A";
                } else if (num >= 80) {
                    grade = "B";
                } else if (num >= 70) {
                    grade = "C";
                } else if (num >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }
            } else {
                if (num > 100 || num < 0) {
                    throw new IllegalArgumentException();
                } else if (num >= 90) {
                    grade = "A";
                } else if (num >= 80) {
                    grade = "B";
                } else if (num >= 70) {
                    grade = "C";
                } else if (num >= 55) {
                    grade = "D";
                } else {
                    grade = "F";
                }
            }
        }
    }
}
