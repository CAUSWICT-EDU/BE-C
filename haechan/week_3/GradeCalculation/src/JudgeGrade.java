import Data.GradeInfo;
import Data.GradeTable;
import Data.StudentInfo;
import Data.StudentTable;

import java.util.ArrayList;

public class JudgeGrade {
    public void judge(StudentTable studentTable, GradeTable policy) {
        ArrayList<StudentInfo> students = studentTable.students;
        GradeInfo requiredSubjectPolicy[] = policy.requiredSubject.toArray(new GradeInfo[0]);
        GradeInfo electiveSubjectPolicy[] = policy.electiveSubject.toArray(new GradeInfo[0]);

        for (int i=0; i<students.size(); i++) {
            for (int j=studentTable.CUSTUOM_INDEX; j<studentTable.ColumnList.size(); j++) {
                StudentInfo student = students.get(i);
                String subject = studentTable.ColumnList.get(j);
                int score = student.subjectScore.get(subject);
                Character subjectGrade;

                if ( student.requiredSubject.equals(subject) ) {
                    subjectGrade = GradingSubject(score, requiredSubjectPolicy);
                }
                else {
                    subjectGrade = GradingSubject(score, electiveSubjectPolicy);
                }

                student.subjectGrade.put( subject, subjectGrade);

            }
        }
    }
    public Character GradingSubject(int score, GradeInfo gradingPolicy[]) {
        for (int i = 0; i < gradingPolicy.length; i++) {
            if (gradingPolicy[i].min <= score && score <= gradingPolicy[i].max) {
                return gradingPolicy[i].grade;
            }
        }
        throw new RuntimeException();
    }
}
