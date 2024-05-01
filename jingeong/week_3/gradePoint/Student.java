import java.util.ArrayList;

public class Student {
    private String stuName;
    private String stuId;
    private String stuMajor;
    private String required;
    private String stuMath;
    private String stuKor;

    public Student(String stuName, String stuId, String stuMajor, String required, String stuMath, String stuKor) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuMajor = stuMajor;
        this.required = required;
        this.stuMath = stuMath;
        this.stuKor = stuKor;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(stuName).append("\t| ").append(stuId).append("\t| ").append(stuMajor).append("\t| ")
                .append(required).append("\t| ").append(stuMath).append("\t| ").append(stuKor);
        return builder.toString();
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public String getRequired() {
        return required;
    }

    public String getStuMath() {
        return stuMath;
    }

    public String getStuKor() {
        return stuKor;
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        System.out.println("=====전체조회=====");
        ArrayList<Student> list = dao.selectList();
        System.out.println(list);
    }


}
