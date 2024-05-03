import domain.CourseDTO;
import domain.StudentDTO;

import java.util.HashMap;
import java.util.Set;

public class StudentGetGrade {
    private StudentDTO dto;
    private CourseDTO[] course;
    private Grade level;

    HashMap<Integer, String> grade = new HashMap<>();

    public StudentGetGrade(StudentDTO dto) {
        this.dto = dto;
        this.course = dto.getCourseDTO();
    }

    public void getGrade() {
        for (int i = 0; i < course.length; i++) {
            if (course[i].getName().equals(dto.getRequired())) {
                level = new Required();
                grade.put(Integer.parseInt(course[i].getPoint()),level.makeGrade(Integer.parseInt(course[i].getPoint())));
            } else {
                level = new Normal();
                grade.put(Integer.parseInt(course[i].getPoint()),level.makeGrade(Integer.parseInt(course[i].getPoint())));
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
        return grade;
    }
}
