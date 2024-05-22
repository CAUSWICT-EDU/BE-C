import Student.Student;
import Student.StudentManager;
import Subject.Subject;

public class GradeEvaluator {
    private static GradeEvaluator instance;

    public static GradeEvaluator getInstance() {
        if (instance == null)
            instance = new GradeEvaluator();

        return instance;
    }

    StudentManager studentManager = new StudentManager();

    public void createStudentTable(){
        CSVReader csvReader = new CSVReader();

        Subject.setRequiredSubjects(csvReader.readCSV("required_subjects.csv"));
        studentManager.addStudents(csvReader.readCSV("students_data.csv"));
    }

    public void printStudentBySubject(){
        for(int i = 0; i < Subject.subjects.length; ++i){
            String subject = Subject.subjects[i];
            System.out.println("---------------------------------");
            System.out.printf("         %s 수강생 학점\n", subject);
            System.out.println(" 이름 :   학번   :필수과목: 점수");
            System.out.println("---------------------------------");

            for(Student student : studentManager.students){
                System.out.print(student.getName());
                System.out.print(" : ");
                System.out.print(student.getStudentID());
                System.out.print(" : ");
                System.out.print(student.getRequiredSubjects());
                System.out.print(" : ");
                System.out.print(student.getScores().get(i).getScore());
                System.out.print(":");
                System.out.print(student.getScores().get(i).getGrade());
                System.out.println(" :");
                System.out.println("---------------------------------");
            }
            System.out.println();
        }
    }
}
