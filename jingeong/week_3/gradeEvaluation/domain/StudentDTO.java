package domain;

public class StudentDTO {

    private static final int COUR_NUM = 2;

    private String stuName;
    private String stuId;
    private String stuMajor;
    private String required;
    private CourseDTO[] courseDTO;

    public StudentDTO(String stuName, String stuId, String stuMajor, String required, String mathPoint, String korPoint) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuMajor = stuMajor;
        this.required = required;
        courseDTO = new CourseDTO[COUR_NUM];

        courseDTO[0] = new CourseDTO("수학", mathPoint);
        courseDTO[1] = new CourseDTO("국어", korPoint);
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

    public CourseDTO[] getCourseDTO() {
        return courseDTO;
    }


}
