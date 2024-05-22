package Subject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GeneralSubject extends Subject {
    private final static HashMap<Integer, String> grade = new LinkedHashMap<>(){{
        put(90, "A");
        put(80, "B");
        put(70, "C");
        put(55, "D");
        put(0, "F");
    }};

    public GeneralSubject(String subject, int socre){
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
