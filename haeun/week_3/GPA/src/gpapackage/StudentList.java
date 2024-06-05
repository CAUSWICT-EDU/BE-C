package gpapackage;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

//public class StudentList {
//
//  private Student[] students; // 학생 배열
//  static int studentcount = 0; // 초기 학생 명수는 0
//  private String[] studentList = new String[100]; // 학생 수 최대 100으로 가정
//
//  public void NewList(String infoFileName) { // 학생 정보 파일에서 정보 읽고 배열에 파싱해서 넣기
//    try {
//      Scanner input = new Scanner(new File(infoFileName));
//      while (input.hasNextLine()) {
//        String line = input.nextLine().trim(); //한 줄씩 학생들 정보 받아서 학생 리스트에 저장
//        if(line.startsWith("이름")){ //맨 위에 줄 정보 칸은 정보 안 받기
//          line = input.nextLine().trim();
//        }
//        studentList[studentcount++] = line;
//        System.out.println(line);
//        if (!line.isEmpty()) {
//          continue;
//        } else
//          break;
//      }
//    } catch (FileNotFoundException e){
//      System.out.printf("파일을 찾을 수 없습니다");
//    }catch (IOException e) {
//      System.out.printf("맞는 입력을 찾을 수 없습니다");
//    }
//  }
//
//  public Student parsinginfo(String[] studentlist){
//    Student student = new Student();
//
//    String studentinfoline = studentlist[0].replace("\t","/");
//    String [] tokens = studentinfoline.split("/");
//    student.name = tokens[0];
//    student.studentid = Integer.parseInt(tokens[1]);
//    student.major = tokens[2];
//    student.requiredsubject= tokens[3];
//    student.mathscore= Integer.parseInt(tokens[4]);
//    student.koreanscore= Integer.parseInt(tokens[5]);
//
//    return student;
//  }
//
//}

public class StudentList {
  private List<Student> studentlist;

  public StudentList() {
    studentlist = new ArrayList<>();
  }
  public void loadStudentData(String fileName) {
    try {
      Scanner scanner = new Scanner(new File(fileName)); //파일 받아오기
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.startsWith("이름")) {
          continue;
        }
        String[] data = line.split("\t"); // 학생 정보 파싱하기 (라인 파싱)
        String name = data[0];
        int studentId = Integer.parseInt(data[1]);
        String major = data[2];
        String requiredSubjectName = data[3];
        int mathScore = Integer.parseInt(data[4]);
        int koreanScore = Integer.parseInt(data[5]);

        Student student = new Student(name, studentId, major); // 학생 객체 생성

        if(requiredSubjectName == "수학"){
          student.addSubject(new RequiredSubject("수학", mathScore));
          student.addSubject(new GeneralSubject("국어", koreanScore));
        }
        else{
          student.addSubject(new RequiredSubject("국어", koreanScore));
          student.addSubject(new GeneralSubject("수학", mathScore));
        }

        studentlist.add(student); //스튜던트리스트에 학생 정보 추가
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다: " + fileName);
    }
  }
  public List<Student> getStudents() {
    return studentlist;
  }
}

