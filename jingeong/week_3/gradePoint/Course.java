import domain.CourseDTO;
import java.util.HashMap;


public class Course {
    private CourseDTO dto;
    private HashMap<String, String> course;


    public Course() {
        this.course.put(dto.getName(), dto.getPoint());

    }

    public HashMap<String, String> getCourse() {
        return course;
    }

    public String getName() {
        return dto.getName();
    }

    public String getPoint() {
        return dto.getPoint();
    }
}
