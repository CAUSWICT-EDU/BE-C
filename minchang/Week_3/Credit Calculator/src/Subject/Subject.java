package Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Subject {
    public static String[] subjects = {"국어", "수학"};

    public static HashMap<String, List<String>> requiredSubjects = new HashMap<>();

    public static void setRequiredSubjects(List<List<String>> requiredSubjects_csv){
        for(List<String> requiredSubject_csv : requiredSubjects_csv){
            String major = requiredSubject_csv.get(0);
            List<String> subjects = new ArrayList<>();

            for(int i = 1; i < requiredSubject_csv.size(); ++i){
                subjects.add(requiredSubject_csv.get(i));
            }

            requiredSubjects.put(major, subjects);
        }
    }

    String name;
    int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public abstract String getGrade();
}
