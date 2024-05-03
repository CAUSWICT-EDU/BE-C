package domain;

import java.util.ArrayList;

public class StudentDTO {
    private String stuName;
    private String stuId;
    private String stuMajor;
    private String required;


    private static final int COUR_NUM = 2;
    private CourseDTO[] courseDTO;

    public StudentDTO(String stuName, String stuId, String stuMajor, String required, String mathPoint, String korPoint) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuMajor = stuMajor;
        this.required = required;
        courseDTO = new CourseDTO[COUR_NUM];

        courseDTO[0] = new CourseDTO("math", mathPoint);
        courseDTO[1] = new CourseDTO("kor", korPoint);
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(stuName).append("\t| ").append(stuId).append("\t| ").append(stuMajor).append("\t| ")
//                .append(required).append("\t| ").append(stuMath).append("\t| ").append(stuKor);
//        return builder.toString();
//    }

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

    public CourseDTO[] getCourseDTO() {
        return courseDTO;
    }

    //    public static void main(String[] args) {
//        domain.StudentDAO dao = new domain.StudentDAO();
//
//        System.out.println("=====전체조회=====");
//        ArrayList<Student> list = dao.selectList();
//        print(list);
//    }

//    private static void print(ArrayList<Student> list) {
//        for (Student dto : list) {
//            System.out.println(dto);
//        }
//    }


}
