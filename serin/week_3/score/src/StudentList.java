import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    ArrayList<Student> StudentList = new ArrayList<>();

    public StudentList(String infoFileName) throws FileNotFoundException {
        File file = new File(infoFileName);
        Scanner input = new Scanner(file);

        while(input.hasNext()) {
            
        }
    }


    public void print(Student student){

    }
}
