import java.util.ArrayList;
import java.util.List;
public class Main {
  public static void main(String args[]){
    Readfile readfile = new Readfile();
    readfile.Readfile("input.csv", 6);
    System.out.println(readfile.students.size());
  }

}
