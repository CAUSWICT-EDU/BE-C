import java.util.HashMap;

public class Normal implements Grade{

    private HashMap<Integer, String> grade = new HashMap<>();

    public Normal() {
        grade.put(90, "A");
        grade.put(80, "B");
        grade.put(70, "C");
        grade.put(55, "D");
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
