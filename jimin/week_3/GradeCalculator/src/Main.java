import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String csvFilePath = currentDirectory + "\\src\\ScoreList.csv";
        String majorGradePolicyFile = currentDirectory + "\\src\\GradePolicy.txt";
        String majorSubjectPolicyFile = currentDirectory + "\\src\\MajorSubjectPolicy.txt";
        // 계속 이렇게 쓰게 될 바에는 추상클래스 하나 만들어서 거기다 둘 걸 그랬다.
        // 처음에 구상할 때 생각을 못 했는데 만들고 나니 공통부분이 생각보다 많았다.
        String outputFileName = "Grade for Students.txt";
        // 결과물 이름 지정 (프로젝트 폴더 내에, src 폴더와 같은 위계에 생김)

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            // DataLoading.java와 PolicyLoading.java에서 Map들을 받기
            Map<String, Double[]> studentScoresMap = DataLoading.loadStudentScores(csvFilePath);
            Map<String, String> studentMajorMap = DataLoading.createStudentMajorMap(csvFilePath);
            Map<String, Integer> majorGradePolicy = PolicyLoading.loadMajorGradePolicy(majorGradePolicyFile);
            Map<String, Integer> subGradePolicy = PolicyLoading.loadSubGradePolicy(majorGradePolicyFile);
            Map<String, String> majorSubjectPolicy = PolicyLoading.loadMajorSubjectPolicy(majorSubjectPolicyFile);

            // 각 학생의 국어 점수와 수학 점수 계산
            for (Map.Entry<String, Double[]> entry : studentScoresMap.entrySet()) {
                String studentId = entry.getKey();
                Double[] scores = entry.getValue();

                // 각 학생의 국어 점수와 수학 점수 추출
                double korScore = scores[1];  // 국어 점수는 배열의 인덱스 1
                double matScore = scores[0];  // 수학 점수는 배열의 인덱스 0

                // 학생의 전공 가져오기
                String studentMajor = studentMajorMap.get(studentId);
                String mainSubject = majorSubjectPolicy.get(studentMajor);

                if (mainSubject != null && mainSubject.equals("국어")) {
                    String korGrade = calculateGradeforMain(korScore, majorGradePolicy);
                    String matGrade = calculateGradeforSub(matScore, subGradePolicy);

                    // 테스트용 결과를 콘솔에 출력
                    System.out.println(studentId + "학생의 등급은 다음과 같습니다.");
                    System.out.println("국어: " + korGrade);
                    System.out.println("수학: " + matGrade);

                    // 결과를 파일에 기록, 그냥 txt로만 출력해도 되지만 내가 보기 좋으라고 터미널까지 출력
                    writer.write(studentId + " 학생의 등급은 다음과 같습니다.");
                    writer.newLine();
                    writer.write("국어: " + korGrade);
                    writer.newLine();
                    writer.write("수학: " + matGrade);
                    writer.newLine();

                } else if (mainSubject != null && mainSubject.equals("수학")) {
                    String korGrade = calculateGradeforSub(korScore, subGradePolicy);
                    String matGrade = calculateGradeforMain(matScore, majorGradePolicy);

                    // 결과를 콘솔에 출력
                    System.out.println(studentId + " 학생의 등급은 다음과 같습니다.");
                    System.out.println("국어: " + korGrade);
                    System.out.println("수학: " + matGrade);

                    // 결과를 파일에 기록
                    writer.write(studentId + " 학생의 등급은 다음과 같습니다.");
                    writer.newLine();
                    writer.write("국어: " + korGrade);
                    writer.newLine();
                    writer.write("수학: " + matGrade);
                    writer.newLine();
                }

                else {
                    // 전공이 정의되지 않은 경우 처리
                    System.out.println("전공 목록에 정의되지 않은 전공입니다");
                }
            }

            System.out.println("학생별 등급 정보가 다음 이름으로 저장되었습니다 : " + outputFileName);

        } catch (IOException e) {
            e.printStackTrace(); // 디버깅용
        }
    }

    // 등급 계산 메서드
    private static String calculateGradeforMain(double score, Map<String, Integer> majorGradePolicy) {
        // 필수 과목에 대한 연산 진행
        if (score >= majorGradePolicy.get("S")) {
            return "S";
        } else if (score >= majorGradePolicy.get("A")) {
            return "A";
        } else if (score >= majorGradePolicy.get("B")) {
            return "B";
        } else if (score >= majorGradePolicy.get("C")) {
            return "C";
        } else if (score >= majorGradePolicy.get("D")) {
            return "D";
        } else {
            return "F";
        }
    }

    private static String calculateGradeforSub(double score, Map<String, Integer> subGradePolicy) {
        // 비필수 과목에 대한 연산 진행
        if (score >= subGradePolicy.get("A")) {
            return "A";
        } else if (score >= subGradePolicy.get("B")) {
            return "B";
        } else if (score >= subGradePolicy.get("C")) {
            return "C";
        } else if (score >= subGradePolicy.get("D")) {
            return "D";
        } else {
            return "F";
        }
    }
}
