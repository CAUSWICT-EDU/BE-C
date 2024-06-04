import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Readfile {
  List<Student> students = new ArrayList<>();
  public void Readfile(String filename, int elementCount) {
    int Count = elementCount; //학생 당 element의 수
    String file = filename;
    String line;


    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      while ((line = br.readLine()) != null) {  //line이 null이 아닐 때 까지 읽는다
        String[] data = line.split("\t");
        if (data.length == Count) { // 항목 수 확인, 정해진 element 수가 아니라면 읽지 않는다
          String name = data[0];
          int id = Integer.parseInt(data[1]);
          String major = data[2];
          String requiredSubject = data[3];
          int score1 = Integer.parseInt(data[4]);
          int score2 = Integer.parseInt(data[5]);

          Student student = new Student(name, id, major, requiredSubject, score1, score2); //생성자에 넣기
          this.students.add(student);  //리스트에 추가
        }
      }
    } catch (IOException e) {
      System.out.println("파일을 읽을 수 없습니다.");
    }
  }
}
