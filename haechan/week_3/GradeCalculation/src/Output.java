import Data.StudentInfo;
import Data.StudentTable;

import java.util.ArrayList;

public class Output {

    public int CELLWIDTH = 8;
    public int ROWSIZE;
    public int COLUMNSIZE;

    ArrayList<StudentInfo> students;
    public void printResult(StudentTable studentsTable) {
        students = studentsTable.students;
        COLUMNSIZE = studentsTable.CUSTUOM_INDEX;
        ROWSIZE = students.size();
        ArrayList<String> columnList = studentsTable.ColumnList;
        for (int i=studentsTable.CUSTUOM_INDEX; i<columnList.size(); i++) {
            printSubjectTable( columnList.get(i) );
        }

    }
    void printSubjectTable(String subject) {
        printTitle(subject);
        for (int i=0; i<students.size(); i++) {
            printStudentInfo(students.get(i), subject);
        }
        System.out.println("");
    }

    void printStudentInfo(StudentInfo student, String subject) {
        printCell(student.name, 1, 2, true);
        printCell(student.id, 1, 2, true);
        printCell(student.requiredSubject, 1, 2, true);
        String gradeResult = student.subjectScore.get(subject)+":"+student.subjectGrade.get(subject);
        printCell(gradeResult, 1, 2, false);
        System.out.println("");

    }

    void printTitle(String subejct) {
        String title = subejct + " 수강생 학점";
        printCell(title, COLUMNSIZE, 1, false);
        System.out.println("");
        printColumn();
        printCellLine();
    }

    void printColumn() {

        printCell("이름", 1, 1, true);
        printCell("학번", 1, 1, true);
        printCell("필수과목", 1, 1, true);
        printCell("점수", 1, 1, false);
    }

    // printCell: 셀의 내용을 출력
    // (string: 내용, cell: 차지하는 셀 수, sort: 글자 정렬방식, end: 칸 구분선 유무)
    void printCell(String string, int cell, int sort, boolean end) {
        int width = cell*CELLWIDTH + (cell - 1);
        if (sort < 0 || sort > 2) sort = 1;
        if ( sort == 0 ) {
            // 좌측정렬 출력
            System.out.print(string);
            for (int i=0; i<width-string.length(); i++) {
                System.out.print(" ");
            }
        }
        else if (sort == 1) {
            // 중앙정렬 출력
            for (int i=0; i<(width-string.length())/2; i++) {
                System.out.print(" ");
            }
            System.out.print(string);
            for (int i=0; i<(width-string.length())/2; i++) {
                System.out.print(" ");
            }
            if (width%2 == 1) System.out.print(" ");
        }
        else {
            // 우측정렬 출력
            for (int i=0; i<width-string.length(); i++) {
                System.out.print(" ");
            }
            System.out.print(string);
        }
        if (end) System.out.print("|");
    }
    void printCellLine() {
        int width = COLUMNSIZE*CELLWIDTH + (COLUMNSIZE-1);
        System.out.println("");
        for (int i=0; i<width; i++) System.out.print("-");
        System.out.println("");
    }
}
