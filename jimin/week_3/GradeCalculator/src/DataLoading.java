import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataLoading {

    public static void main(String[] args) {
        String csvFilePath = "C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\ScoreList.csv"; // CSV 파일 경로

        // loadStudentScores 메서드 호출하여 studentScoresMap 가져오기
        Map<String, Double[]> studentScoresMap = loadStudentScores(csvFilePath);

        // studentScoresMap 사용 예시 (여기서는 출력만 함)
        for (Map.Entry<String, Double[]> entry : studentScoresMap.entrySet()) {
            String studentId = entry.getKey();
            Double[] scores = entry.getValue();
            System.out.println("학번: " + studentId + ", 수학 점수: " + scores[0] + ", 국어 점수: " + scores[1]);
        }

        // StudentMajor 생성 및 출력
        Map<String, String> studentMajorMap = createStudentMajorMap(csvFilePath);
        System.out.println("StudentMajor Map: " + studentMajorMap);
    }

    public static Map<String, Double[]> loadStudentScores(String csvFilePath) {
        Map<String, Double[]> studentScoresMap = new HashMap<>(); // 학번을 key로 하는 Map 생성

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // CSV 라인을 쉼표(,)로 분리

                // CSV 형식이 "이름,학번,전공,필수 과목,수학 점수,국어 점수" 순서로 되어있는 경우
                if (parts.length == 6) {
                    String studentId = parts[1].trim(); // 학번 추출
                    double mathScore = Double.parseDouble(parts[4].trim()); // 수학 점수 추출
                    double koreanScore = Double.parseDouble(parts[5].trim()); // 국어 점수 추출

                    // 수학 점수와 국어 점수를 배열로 묶어서 Map에 추가
                    Double[] scores = { mathScore, koreanScore };
                    studentScoresMap.put(studentId, scores);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return studentScoresMap; // studentScoresMap 반환
    }

    public static Map<String, String> createStudentMajorMap(String csvFilePath) {
        Map<String, String> studentMajorMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // CSV 라인을 쉼표(,)로 분리

                // CSV 형식이 "이름,학번,전공,필수 과목,수학 점수,국어 점수" 순서로 되어있는 경우
                if (parts.length == 6) {
                    String studentId = parts[1].trim(); // 학번 추출
                    String major = parts[2].trim(); // 전공 추출

                    // 전공을 key, 학번을 value로 Map에 추가
                    studentMajorMap.put(studentId, major);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentMajorMap; // studentMajorMap 반환
    }
}
