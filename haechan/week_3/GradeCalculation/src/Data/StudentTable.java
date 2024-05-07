package Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentTable extends StudentInfo{


    public ArrayList<String> ColumnList = new ArrayList<> (
            List.of("이름", "학번", "전공", "필수 과목")
    );

    public int CUSTUOM_INDEX = 4;
    // (0~3번 인덱스까지는 필수항목, 4번인덱스부터는 자유)
    public ArrayList<StudentInfo> students = new ArrayList<>();

    // addSubject: 새로운 과목 칼럼을 추가하는 함수

    public void setColumns(String line) {
        int index=0;
        String[] data =Arrays.stream(line.split(","))
                .map(String::trim).toArray(String[]::new);
        for (int i=0; i<ColumnList.size(); i++) {
            if ( !ColumnList.get(i).equals(data[i]) )
                throw new RuntimeException();
        }
        for (int i=ColumnList.size(); i<data.length; i++) {
            ColumnList.add(data[i].replace("점수",""));
        }
    }

    // addData: 입력받은 String을 Row(열)로 해석해 데이터를 추가하는 함수
    public void addData (String line) {
        String[] data =Arrays.stream(line.split(","))
                .map(String::trim).toArray(String[]::new);
        StudentInfo tempStudent = new StudentInfo() ;
        tempStudent.name = data[0];
        tempStudent.id = data[1];
        tempStudent.major = data[2];
        tempStudent.requiredSubject = data[3];
        for (int i=CUSTUOM_INDEX; i<data.length; i++) {
            int score = Integer.parseInt(data[i]);
            tempStudent.subjectScore.put(ColumnList.get(i), score );
        }
        students.add(tempStudent);
    }
}
