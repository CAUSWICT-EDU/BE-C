package domain;

public class CourseDTO {

    private String point;
    private String name;

    public CourseDTO(String name, String point) {
        this.name = name;
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
}
