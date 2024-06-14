import java.io.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String csvFilePath = "C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\ScoreList.csv";
        String majorGradePolicyFile = "C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\GradePolicy.txt";
        String majorSubjectPolicyFile = "C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\MajorSubjectPolicy.txt";
        String outputFilePath = "Grade for Students.txt"; // 저장할 파일 경로

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            // MAP들 가져와 인스턴스화
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
                double korScore = scores[1];  // 국어 점수는 배열의 두 번째 요소 (인덱스 1)
                double matScore = scores[0];  // 수학 점수는 배열의 첫 번째 요소 (인덱스 0)

                // 학생의 전공 가져오기
                String studentMajor = studentMajorMap.get(studentId);
                String mainSubject = majorSubjectPolicy.get(studentMajor);

                if (mainSubject != null && mainSubject.equals("국어")) {
                    String korGrade = calculateGradeforMain(korScore, majorGradePolicy);
                    String matGrade = calculateGradeforSub(matScore, subGradePolicy);

                    // 결과를 콘솔에 출력
                    System.out.println(studentId + " 학생의 등급은 다음과 같습니다.");
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
                } else {
                    // 전공이 정의되지 않은 경우
                    System.out.println("전공 목록에 정의되지 않은 전공입니다");
                }
            }

            System.out.println("학생별 등급 정보가 다음 경로로 저장되었습니다 : " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 등급 계산 메서드
    private static String calculateGradeforMain(double score, Map<String, Integer> majorGradePolicy) {
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
