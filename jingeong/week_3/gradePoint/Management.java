import domain.CourseDTO;
import domain.DAO;
import domain.StudentDTO;

import java.util.ArrayList;

public class Management {
    private static ArrayList<StudentDTO> students;
    StringBuilder sb = new StringBuilder();
    StudentGetGrade student;
    Course course;

    public static void main(String[] args) {
        DAO dao = new DAO();

        students = dao.selectList();

        for (int i = 0; i < students.size(); i++) {
            StudentGetGrade student = new StudentGetGrade(students.get(i));
            student.getGrade();
            System.out.println(student.getName() + " " + student.getGradeList());
        }




    }


}
