package gpapackage;

public class Test {
  public static void main(String[] args) {
    StudentList studentList = new StudentList();
    studentList.loadStudentData("studentinfo.txt");

    GPACalculator calculator = new GPACalculator(studentList);
    calculator.calculateGrades();
    calculator.printReport();
  }
}