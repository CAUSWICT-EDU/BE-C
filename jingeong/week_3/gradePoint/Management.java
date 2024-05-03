import domain.CourseDTO;
import domain.DAO;
import domain.StudentDTO;

import java.util.ArrayList;

public class Management {
    private static ArrayList<StudentDTO> students;
    private static StringBuilder sb = new StringBuilder();
    private static StudentGetGrade student;

    public static void main(String[] args) {
        DAO dao = new DAO();

        students = dao.selectList();

        for (int i = 0; i < students.size(); i++) {
            student = new StudentGetGrade(students.get(i));
            student.getGrade();
            print();
        }
        System.out.println(sb);

    }

    public static void print() {
        sb.append(student.getName()).append(" ").append(student.getId()).append(" ")
                .append(student.getMajor()).append(" ").append(student.getRequired()).append("\n");
        for (int i = 0; i < student.getCourse().length; i++) {
            sb.append(student.getCourse()[i].getName()).append(" 성적 : ")
                    .append(student.getCourse()[i].getPoint()).append(" || ")
                    .append(student.getCourse()[i].getName()).append(" 등급 : ")
                    .append(student.gradeList.get(Integer.parseInt(student.getCourse()[i].getPoint()))).append(" ")
                    .append("\n");
        }
        sb.append("\n\n");

    }


}
