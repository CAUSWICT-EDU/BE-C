package Data;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.ArrayList;
/*
    GradeTable: GradeInfo의 배열인, 하나의 학점 정책의 데이터와 관리하는 메소드를 초함하는 클래스
*/
public class GradeTable extends GradeInfo{
    public ArrayList<GradeInfo> requiredSubject = new ArrayList<>();
    public ArrayList<GradeInfo> electiveSubject = new ArrayList<>();

    // makeGradeTable: JSON object를 기반으로 학점정책 배열 데이터를 생성
    public void makeGradeTable(JSONObject jsonObject) {
        // 필수과목 정책
        requiredSubject = makeGradePolicy((JSONArray) jsonObject.get("RequiredSubject"));

        // 선택과목 정책
        electiveSubject = makeGradePolicy((JSONArray) jsonObject.get("ElectiveSubject"));
    }

    // makeGradePolicy: 학점정책에서 각 등급별 점수 조건을 해석하여 배열에 할당
    public ArrayList<GradeInfo> makeGradePolicy(JSONArray jsonArray) {
        ArrayList<GradeInfo> gradePolicy = new ArrayList<>();

        for (int i=0; i<jsonArray.size(); i++) {
            GradeInfo gradeInfo = new GradeInfo();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

            // 각 등급 조건을 해석
            gradeInfo.grade = ((String) ( jsonObject ).get("grade")).charAt(0);
            gradeInfo.min = ((Long) ( jsonObject ).get("min")).intValue();;
            gradeInfo.max =  ((Long) ( jsonObject ).get("max")).intValue();;

            // 배열에 추가
            gradePolicy.add(gradeInfo);
        }
        return gradePolicy;
    }

}
