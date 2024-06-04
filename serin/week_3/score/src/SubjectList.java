import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubjectList {
    public static final int KoreanID = 0;
    public static final int MathID = 1;
    private static Subject Korean = new Subject("국어",KoreanID);
    private static Subject Math = new Subject("수학",MathID);
    private static ArrayList<Subject> subjectList = new ArrayList<>(Arrays.asList(Korean,Math));


    public static ArrayList<Subject> getSubjectList(){
        return subjectList;
    }/*프로그램에서는 하나의 subjectList가 공유되므로
    객체를 매번 생성해서 하는 방법보다 static으로 선언해서 class로 접근하는 것이 더 효율적이라고 생각함*/



}
