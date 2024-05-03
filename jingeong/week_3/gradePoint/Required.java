import java.util.HashMap;
import java.util.Set;

public class Required implements Grade{
    private HashMap<Integer, String> grade;

    public Required() {
        grade.put(95, "S");
        grade.put(90, "A");
        grade.put(80, "B");
        grade.put(70, "C");
        grade.put(60, "D");
        grade.put(0, "F");
    }

    @Override
    public String makeGrade(int point) {
        for (Integer key : grade.keySet()) {
            if (point >= key) {
                point = key;
                break;
            }
        }
        return grade.get(point);
    }
}
