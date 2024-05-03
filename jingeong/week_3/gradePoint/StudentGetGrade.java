import domain.CourseDTO;
import domain.StudentDTO;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StudentGetGrade {
    private StudentDTO dto;
    private CourseDTO[] course;

    HashMap<Integer, String> gradeList = new LinkedHashMap<>();

    public StudentGetGrade(StudentDTO dto) {
        this.dto = dto;
        this.course = dto.getCourseDTO();
    }

    public void getGrade() {
        int point;
        String getGrade;
        for (int i = 0; i < course.length; i++) {
            point = Integer.parseInt(course[i].getPoint());
            if (course[i].getName().equals(dto.getRequired())) {
                Grade level = new Required(point);
                getGrade = level.makeGrade();
                gradeList.put(point, getGrade);
            } else {
                Grade level = new Normal(point);
                getGrade = level.makeGrade();
                gradeList.put(point, getGrade);
            }
        }

    }

    public String getName() {
        return dto.getStuName();
    }

    public String getId() {
        return dto.getStuId();
    }

    public String getRequired() {
        return dto.getRequired();
    }

    public String getMajor() {
        return dto.getStuMajor();
    }

    public HashMap<Integer, String> getGradeList() {
        return gradeList;
    }

    public CourseDTO[] getCourse() {
        return course;
    }
}
