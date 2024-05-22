public class Application {
    public static void main(String[] args) {
        GradeEvaluator gradeEvaluator = GradeEvaluator.getInstance();
        gradeEvaluator.createStudentTable();
        gradeEvaluator.printStudentBySubject();
    }
}