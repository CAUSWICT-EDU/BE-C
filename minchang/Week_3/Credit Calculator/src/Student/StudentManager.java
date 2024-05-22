package Student;

import Subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance;

    public static StudentManager getInstance() {
        if (instance == null)
            instance = new StudentManager();

        return instance;
    }

    public ArrayList<Student> students = new ArrayList<>();

    public void addStudent(List<String> data){
        Student student = new Student();
        student.setName(data.get(0));
        student.setStudentID(Integer.parseInt(data.get(1)));
        student.setMajor(data.get(2));
        student.setRequiredSubjects(data.get(2));
        for(int i = 0; i < Subject.subjects.length; ++i){
            student.addScores(Subject.subjects[i], Integer.parseInt(data.get(3 + i)));
        }

        students.add(student);
    }

    public void addStudents(List<List<String>> studentsData){
        for(List<String> data : studentsData){
            addStudent(data);
        }
    }
}
