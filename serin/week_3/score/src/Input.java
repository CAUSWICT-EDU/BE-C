import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private ArrayList<Student> studentList = new ArrayList<>();

    private int cntStudent = 0;
    private Scoring[] scoring = {new generalScoring(),new requiredScoring()};
    public Input(){

    }
    public ArrayList<Student> parsing(String infoFileName) throws FileNotFoundException {
        File file = new File(infoFileName);
        Scanner input = new Scanner(file);

        while(input.hasNext()) {
            String line = input.nextLine();
            String[] tokens = line.split(" ");

            studentList.add(cntStudent,new Student(tokens[0],tokens[1],tokens[2])); //각 배열 원소 초기화

            if (tokens[3].equals("국어")){
                studentList.get(cntStudent).setRequired(SubjectList.getSubjectList().get(0));
            }
            else if (tokens[3].equals("수학")){
                studentList.get(cntStudent).setRequired(SubjectList.getSubjectList().get(1));
            } //해당 학생의 필수과목이 무엇인지 파악해서 subjectList에서 가져오고 required 필드값에 저장한다

            int p1, p2;
            p1 = Integer.parseInt(tokens[4]);
            studentList.get(cntStudent).getScoreList().add(new Score(tokens[1],p1,SubjectList.getSubjectList().get(0)));
            //학생의 score 객체 생성해서 저장
            studentList.get(cntStudent).getScoreList().get(0).setScore(p1); //과목의 점수를 해당 학생의 scoreList에 저장
            studentList.get(cntStudent).getScoreList().get(0).setSubject(SubjectList.getSubjectList().get(0));
            //이 점수가 어떤 과목의 점수인지 저장-국어 과목

            p2 = Integer.parseInt(tokens[5]);
            studentList.get(cntStudent).getScoreList().add(new Score(tokens[1],p2,SubjectList.getSubjectList().get(1)));
            //학생의 score 객체 생성해서 저장
            studentList.get(cntStudent).getScoreList().get(1).setScore(p2); //과목의 점수를 해당 학생의 scoreList에 저장
            studentList.get(cntStudent).getScoreList().get(1).setSubject(SubjectList.getSubjectList().get(1));
            //이 점수가 어떤 과목의 점수인지 저장-수학 과목


            if (studentList.get(cntStudent).getRequired() == studentList.get(cntStudent).getScoreList().get(0).getSubject()){
                //해당 학생의 필수 과목이 첫번째 적힌 과목일 경우
                String grade;
                grade = scoring[1].getGrade(p1);
                studentList.get(cntStudent).getScoreList().get(0).setGrade(grade); //첫번째 과목의 점수 grade 매겨서 저장
                studentList.get(cntStudent).getScoreList().get(0).getSubject().setSubjectId(1);
                //첫번째 과목 점수의 gradeType을 필수과목으로 바꾸기
                //studentList.get(cntStudent).getRequired().setGrade(grade); //해당 학생의 필수 과목에도 grade 저장


                grade = scoring[0].getGrade(p2);
                studentList.get(cntStudent).getScoreList().get(1).setGrade(grade);
                //두번째 과목의 점수 grade 매겨서 저장
            }
            else {
                //해당 학생의 필수 과목이 두번째 적힌 과목일 경우
                String grade;
                grade = scoring[0].getGrade(p1);
                studentList.get(cntStudent).getScoreList().get(0).setGrade(grade);

                grade = scoring[1].getGrade(p2);
                studentList.get(cntStudent).getScoreList().get(1).setGrade(grade);
                studentList.get(cntStudent).getScoreList().get(1).getSubject().setSubjectId(1);
                //두번째 과목 점수의 gradeType을 필수과목으로 바꾸기

                //studentList.get(cntStudent).getRequired().setGrade(grade); //해당 학생의 필수 과목에도 grade 저장

            }
            cntStudent++;
        }
        return studentList;
    }

}
