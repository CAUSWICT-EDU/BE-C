
public class Subject {

    int score; // 점수
    String value; // 학점
    int keySubjectID; // 필수과목 ID
    int subjectID; // 과목 ID

    Subject (int keySubjectID, String stringScore, int subjectID) { // 과목 점수와 과목 번호를 입력 받는다.
        score = Integer.parseInt(stringScore); // String 점수를 int 점수로 바꾼다
        this.keySubjectID = keySubjectID;
        this.subjectID = subjectID;

        if (keySubjectID == subjectID) { // 과목 ID 과 필수과목 ID 와 같은 경우 필수 과목 학점 부여 정책을 따른다.
            KeyEvaluation evaluation = new KeyEvaluation();
            value = evaluation.getValue(score);
        }
        else { // 과목 ID 와 필수 과목 ID 가 다른 경우 일반 과목 학점 부여 정책을 따른다.
            BasicEvaluation evaluation = new BasicEvaluation();
            value = evaluation.getValue(score);
        }
    }


}
