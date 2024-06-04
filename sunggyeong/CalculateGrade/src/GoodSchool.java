import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GoodSchool {
    private static int studentNumber = 5;
    private static int subjectNumber = 2;
    private static int majorNum = 2;
    private static String[] subjectStr = new String[subjectNumber];
    private static String[] majors = new String[majorNum];
    private static ArrayList<Student> students = new ArrayList<>(studentNumber);
    private static HashMap<String, String> requiredSubjects = new HashMap<>();

    static {
        subjectStr[0] = "수학";
        subjectStr[1] = "국어";
        majors[0] = "컴퓨터공학과";
        majors[1] = "국어국문학과";

        // 초기화
        requiredSubjects.put(majors[0], subjectStr[0]);
        requiredSubjects.put(majors[1], subjectStr[1]);
    }

    GoodSchool() {

    }

    GoodSchool(String fileName) {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                String[] tokens = line.split(" ");

                // 학생 생성 및 정보 설정
                Student student = new Student();
                student.setName(tokens[0]);
                student.setId(tokens[1]);
                student.setMajor(tokens[2]);
                student.getSubject(0).setScore(Double.parseDouble(tokens[4]));
                student.getSubject(1).setScore(Double.parseDouble(tokens[5]));
                students.add(student);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 전공별 필수 과목 추가 메서드
    public void addMajor(String major, String subject) {
        requiredSubjects.put(major, subject);
    }

    public static int getStudentNumber() {
        return studentNumber;
    }

    public static int getSubjectNumber() {
        return subjectNumber;
    }

    // 학생 목록 반환 메서드
    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static String getSubjectName(int num) {
        return subjectStr[num];
    }

    public static String getRequiredSubject(String major) {
        return requiredSubjects.get(major);
    }

    public static void resultReport() {
        for (int i = 0; i < subjectNumber; i++) {
            System.out.println("---------------------------------------------");
            System.out.println("      " + subjectStr[i] + "      수강생 학점 보고서              ");
            System.out.println("---------------------------------------------");
            System.out.println("  이름       |   학번       |   중점과목   |      점수    ");
            System.out.println("---------------------------------------------");
            for (Student student : students) {
                String major = student.getMajor();
                String mainSubject = requiredSubjects.get(major);
                System.out.printf("  %-10s|  %09d  |     %s    |      %.2f:%s     |", student.getName(), Integer.parseInt(student.getId()), mainSubject, student.getSubject(i).getScore(),student.getSubject(i).getGrade());
                System.out.println();
            }
            System.out.println("---------------------------------------------");
        }
    }
}