package Data;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.ArrayList;
import java.util.List;


public class GradeTable extends GradeInfo{
    public ArrayList<GradeInfo> requiredSubject = new ArrayList<>();
    public ArrayList<GradeInfo> electiveSubject = new ArrayList<>();

    public void makeGradeTable(JSONObject jsonObject) {
        requiredSubject = makeGradePolicy((JSONArray) jsonObject.get("RequiredSubject"));
        electiveSubject = makeGradePolicy((JSONArray) jsonObject.get("ElectiveSubject"));

    }

    public ArrayList<GradeInfo> makeGradePolicy(JSONArray jsonArray) {
        ArrayList<GradeInfo> gradePolicy = new ArrayList<>();

        for (int i=0; i<jsonArray.size(); i++) {
            GradeInfo gradeInfo = new GradeInfo();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

            gradeInfo.grade = ((String) ( jsonObject ).get("grade")).charAt(0);
            gradeInfo.min = ((Long) ( jsonObject ).get("min")).intValue();;
            gradeInfo.max =  ((Long) ( jsonObject ).get("max")).intValue();;

            gradePolicy.add(gradeInfo);
        }
        return gradePolicy;
    }

}
