import java.util.ArrayList;
public class Major {
    private String majorName;
    private Subject requiredSubject;
    static ArrayList<Student> majorStudents = new ArrayList<>();

    Major(String majorName, Subject requiredSubject){
        this.majorName=majorName;
        this.requiredSubject=requiredSubject;
        School.majors.add(this);
    }

    public Subject getRequiredSubject() {
        return requiredSubject;
    }
}
