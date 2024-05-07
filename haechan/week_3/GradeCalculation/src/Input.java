import Data.GradeInfo;
import Data.GradeTable;
import Data.StudentTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Input {
    public StudentTable readCSV(String fileName) throws IOException {
        StudentTable studentTable = new StudentTable();

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        studentTable.setColumns( br.readLine() );

        while (true) {
            String line = br.readLine();
            if (line == null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.

            studentTable.addData(line);

        }
        return studentTable;
    }

    public GradeTable readPolicy(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(fileName));
        GradeTable gradePolicy = new GradeTable();
        gradePolicy.makeGradeTable( jsonObject );
        return gradePolicy;
    }
}
