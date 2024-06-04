package Subject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RequiredSubject extends Subject {
    private final static HashMap<Integer, String> grade = new LinkedHashMap<>(){{
        put(95, "S");
        put(90, "A");
        put(80, "B");
        put(70, "C");
        put(60, "D");
        put(0, "F");
    }};

    public RequiredSubject(String subject, int socre){
        name = subject;
        this.score = socre;
    }

    @Override
    public String getGrade() {
        for (Integer key : grade.keySet()) {
            if (score >= key) {
                score = key;
                break;
            }
        }
        return grade.get(score);
    }
}
