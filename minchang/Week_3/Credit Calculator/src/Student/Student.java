package Student;

import Subject.Subject;
import Subject.RequiredSubject;
import Subject.GeneralSubject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int studentID;
    String major;

    List<String> requiredSubjects;

    List<Subject> scores = new ArrayList<>();

    // getter
    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public List<String> getRequiredSubjects() {
        return requiredSubjects;
    }

    public List<Subject> getScores() {
        return scores;
    }

    // setter

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setRequiredSubjects(String major) {
        this.requiredSubjects = Subject.requiredSubjects.get(major);
    }

    public void addScores(String subject, int score) {
        if(requiredSubjects.contains(subject)){
            scores.add(new RequiredSubject(subject, score));
        }
        else{
            scores.add(new GeneralSubject(subject, score));
        }
    }
}
