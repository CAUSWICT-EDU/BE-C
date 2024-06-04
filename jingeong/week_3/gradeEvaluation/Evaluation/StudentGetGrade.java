package Evaluation;

import domain.CourseDTO;
import domain.StudentDTO;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StudentGetGrade {
    private StudentDTO dto;
    private CourseDTO[] course;
    private Grade level;

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

            if (isRequired(i)) {
                level = new Required(point);
                gradeList.put(point, level.makeGrade());
            } else {
                level = new Normal(point);
                gradeList.put(point, level.makeGrade());
            }
        }

    }

    private boolean isRequired(int i) {
        return course[i].getName().equals(dto.getRequired());
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
