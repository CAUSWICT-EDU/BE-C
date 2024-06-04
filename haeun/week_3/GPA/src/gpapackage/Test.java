package gpapackage;

//import java.io.File;

//public class Test {
//
//  public static void main(String args[]) {
//    StudentList List = new StudentList();
//    List.NewList("studentinfo.txt");
//
//  }
//}

public class Test {
  public static void main(String[] args) {
    StudentList studentList = new StudentList();
    studentList.loadStudentData("studentinfo.txt");

    GPACalculator calculator = new GPACalculator(studentList);
    calculator.calculateGrades();
    calculator.printReport();
  }
}