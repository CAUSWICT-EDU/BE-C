import Evaluation.StudentGetGrade;

public class View {

    private static final StringBuilder sb = new StringBuilder();

    public static StringBuilder print(StudentGetGrade student) {
        sb.append(student.getName()).append(" ").append(student.getId()).append(" ")
                .append(student.getMajor()).append(" ").append(student.getRequired()).append("\n");
        for (int i = 0; i < student.getCourse().length; i++) {
            sb.append(student.getCourse()[i].getName()).append(" 성적 : ")
                    .append(student.getCourse()[i].getPoint()).append(" || ")
                    .append(student.getCourse()[i].getName()).append(" 등급 : ")
                    .append(student.getGradeList().get(Integer.parseInt(student.getCourse()[i].getPoint()))).append(" ")
                    .append("\n");
        }
        sb.append("\n\n");

        return sb;
    }
}
