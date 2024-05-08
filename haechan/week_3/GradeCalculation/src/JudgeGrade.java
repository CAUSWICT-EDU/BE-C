import Data.GradeInfo;
import Data.GradeTable;
import Data.StudentInfo;
import Data.StudentTable;

import java.util.ArrayList;

public class JudgeGrade {
    public void judge(StudentTable studentTable, GradeTable policy) {
        // 학생 점수 데이터
        ArrayList<StudentInfo> students = studentTable.students;

        // 필수과목 학점 정책
        GradeInfo requiredSubjectPolicy[] = policy.requiredSubject.toArray(new GradeInfo[0]);

        // 선택과목 학점 정책
        GradeInfo electiveSubjectPolicy[] = policy.electiveSubject.toArray(new GradeInfo[0]);

        // 모든 학생에 대해 학점 판단
        for (int i=0; i<students.size(); i++) {
            // 각 학생의 과목에 대해서 반복
            for (int j=studentTable.CUSTUOM_INDEX; j<studentTable.ColumnList.size(); j++) {
                StudentInfo student = students.get(i);
                String subject = studentTable.ColumnList.get(j);
                int score = student.subjectScore.get(subject);
                Character subjectGrade;

                // 해당 과목이 필수과목이라면
                if ( student.requiredSubject.equals(subject) ) {
                    // 필수 과목 학점 정책으로 학점 평가
                    subjectGrade = GradingSubject(score, requiredSubjectPolicy);
                }
                else {
                    // 선택 과목 학점 정책으로 학점 평가
                    subjectGrade = GradingSubject(score, electiveSubjectPolicy);
                }
                // 학생 학점 추가
                student.subjectGrade.put( subject, subjectGrade);

            }
        }
    }
    public Character GradingSubject(int score, GradeInfo gradingPolicy[]) {
        // 각 학점 등급에 대해 반복
        for (int i = 0; i < gradingPolicy.length; i++) {
            // 학생의 점수가 해당 학점 등급의 점수구간 사이라면
            if (gradingPolicy[i].min <= score && score <= gradingPolicy[i].max) {
                return gradingPolicy[i].grade;
            }
        }
        // 모든 학점등급에 해당하지 않으면 오류 생성
        throw new RuntimeException();
    }
}
