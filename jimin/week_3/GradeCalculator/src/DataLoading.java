import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataLoading {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
//        System.out.println(currentDirectory); //테스트용
        String csvFilePath = currentDirectory + "\\src\\ScoreList.csv"; // CSV 파일 동적 경로

        // studentScoresMap 생성 및 (학번이 key, 그 학생의 점수 두 개가 value, 각 점수는 쉼표로 구분)
        Map<String, Double[]> studentScoresMap = loadStudentScores(csvFilePath);

        // studentScoresMap 출력테스트
        for (Map.Entry<String, Double[]> entry : studentScoresMap.entrySet()) {
            String studentId = entry.getKey();
            Double[] scores = entry.getValue();
            System.out.println("학번: " + studentId + ", 수학 점수: " + scores[0] + ", 국어 점수: " + scores[1]);
        }

        // StudentMajorMap 생성 및 출력 테스트 (학번이 key, 그 학생의 전공이 value)
        Map<String, String> studentMajorMap = createStudentMajorMap(csvFilePath);
        System.out.println("StudentMajor Map: " + studentMajorMap);
    }

    public static Map<String, Double[]> loadStudentScores(String csvFilePath) {
        Map<String, Double[]> studentScoresMap = new HashMap<>(); // 학번을 key로

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) { //학생수가 변동해도 끝까지 모두 실행
                String[] parts = line.split(","); // CSV 라인을 쉼표(,)로 분리

                // CSV 형식이 "이름,학번,전공,필수 과목,수학 점수,국어 점수" 순서
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
            e.printStackTrace(); // 디버깅용
        }

        return studentScoresMap; // studentScoresMap 반환
    }

    public static Map<String, String> createStudentMajorMap(String csvFilePath) {
        Map<String, String> studentMajorMap = new HashMap<>(); //학번을 key로

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // CSV 라인을 쉼표(,)로 분리

                // CSV 형식이 "이름,학번,전공,필수 과목,수학 점수,국어 점수" 순서
                if (parts.length == 6) {
                    String studentId = parts[1].trim(); // 학번 추출
                    String major = parts[2].trim(); // 전공 추출

                    // 전공을 key, 학번을 value로 Map에 추가
                    studentMajorMap.put(studentId, major);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // 디버깅용
        }

        return studentMajorMap; // studentMajorMap 반환
    }
}
