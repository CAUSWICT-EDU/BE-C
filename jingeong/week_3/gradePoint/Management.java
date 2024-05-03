import Evaluation.StudentGetGrade;
import domain.DAO;
import domain.StudentDTO;

import java.util.ArrayList;

public class Management {
    public static void main(String[] args) {
        ArrayList<StudentDTO> students;
        StudentGetGrade student;
        StringBuilder sb = new StringBuilder();

        DAO dao = new DAO();

        students = dao.selectList();

        for (StudentDTO studentDTO : students) {
            student = new StudentGetGrade(studentDTO);
            student.getGrade();
            sb = View.print(student);
        }

        System.out.println(sb);

    }

}
