package Evaluation;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Required extends Grade{
    private final static HashMap<Integer, String> grade = new LinkedHashMap<>();
    private int point;

    public Required(int point) {
        grade.put(95, "S");
        grade.put(90, "A");
        grade.put(80, "B");
        grade.put(70, "C");
        grade.put(60, "D");
        grade.put(0, "F");

        this.point = point;
    }

    @Override
    public String makeGrade() {
        for (Integer key : grade.keySet()) {
            if (point >= key) {
                point = key;
                break;
            }
        }
        return grade.get(point);
    }
}
