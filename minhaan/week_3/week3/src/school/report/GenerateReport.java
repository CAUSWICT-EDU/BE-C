package school.report;

import java.util.ArrayList;

import school.School;
import school.Student;
import school.Subject;
import school.Score;
import grade.GradeEval;
import grade.nonMajorEval;
import grade.MajorEval;
import utils.Define;

// 학생 성적 보고서를 생성하는 클래스
public class GenerateReport {
    // 학교의 인스턴스를 가져옴
    School school = School.getInstance();
    // 보고서 포맷을 위한 상수
    public static final String TITLE = " 반 성적표 \t\t\n";
    public static final String HEADER = " 이름| 학번 | 전공| 성적| \n";
    public static final String LINE = "----------------------------\n";

    private StringBuffer buffer = new StringBuffer();

    // 보고서를 생성하는 메서드
    public String getReport() {
        // 각 과목에 대해 반복
        ArrayList<Subject> subjectList = school.getSubjectList();
        for (Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        // 생성된 보고서 반환
        return buffer.toString();
    }

    // 특정 과목에 대한 헤더 생성 메서드
    public void makeHeader(Subject subject) {
        buffer.append(GenerateReport.LINE);
        buffer.append("\t" + subject.getSubjectName());
        buffer.append(GenerateReport.TITLE);
        buffer.append(GenerateReport.HEADER);
        buffer.append(GenerateReport.LINE);
    }

    // 특정 과목에 대한 본문 생성 메서드
    public void makeBody(Subject subject) {
        // 해당 과목의 학생 목록을 가져옴
        ArrayList<Student> studentList = subject.getStudentList();
        // 각 학생에 대해 반복
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            // 학생 세부 정보를 보고서에 추가
            buffer.append(student.getStudentName());
            buffer.append(" | ");
            buffer.append(student.getStudentID());
            buffer.append(" | ");
            buffer.append(student.getMajorSubject().getSubjectName());
            buffer.append(" | ");
            // 학생의 성적과 학점을 가져와 보고서에 추가
            getScoreGrade(student, subject.getSubjectID());
            buffer.append("\n");
            buffer.append(LINE);
        }
    }

    // 학생의 성적과 학점을 가져오는 메서드
    public void getScoreGrade(Student student, int subjectID) {
        ArrayList<Score> scoreList = student.getScoreList();
        int majorID = student.getMajorSubject().getSubjectID();

        // 학점 평가 전략 배열
        GradeEval[] gradeEvaluation = { new nonMajorEval(), new MajorEval() };
        // 각 성적에 대해 반복
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            // 성적이 현재 과목에 대한 것인지 확인
            if (score.getSubject().getSubjectID() == subjectID) {
                String grade;
                // 과목 유형에 따라 학점 평가 방법 결정
                if (score.getSubject().getSubjectID() == majorID) {
                    grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
                } else {
                    grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
                }
                // 성적과 학점을 보고서에 추가
                buffer.append(score.getPoint());
                buffer.append(":");
                buffer.append(grade);
                buffer.append(" | ");
            }
        }
    }
    public void makeFooter() {
        buffer.append("\n");
    }
}
