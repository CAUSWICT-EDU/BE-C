package Data;

import java.util.HashMap;
/*
    StudentInfo: 학생의 정보에 관한 클래스 (학생 한 명에 대한 데이터)
    이름과 학번, 학과, 필수과목은 String, 과목점수와 과목학점은 Map 구조로 작성 (과목 갯수가 3개 이상일 경우까지 고려)
 */
public class StudentInfo {
    public String name; // 학생 이름
    public String id; // 학생  학번
    public String major; // 학생 전공
    public String requiredSubject; // 필수 과목
    public HashMap<String, Integer> subjectScore = new HashMap<>(); // 과목별 점수
    public HashMap<String, Character> subjectGrade = new HashMap<>(); // 과목별 학점



}