import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PolicyLoading {

    public static void main(String[] args) {
        Map<String, Integer> majorGradePolicy = loadMajorGradePolicy("C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\GradePolicy.txt");
        Map<String, Integer> subGradePolicy = loadSubGradePolicy("C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\GradePolicy.txt");
        Map<String, String> majorSubjectPolicy = loadMajorSubjectPolicy("C:\\workspace_1\\GradeCalculator\\GradeCalculator\\src\\MajorSubjectPolicy.txt");

        // 테스트를 위해 로드된 맵들을 출력
        System.out.println("Major Grade Policy: " + majorGradePolicy);
        System.out.println("Subject Grade Policy: " + subGradePolicy);
        System.out.println("Major Subject Policy: " + majorSubjectPolicy);
    }

    public static Map<String, Integer> loadMajorGradePolicy(String fileName) {
        Map<String, Integer> majorGradePolicy = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    majorGradePolicy.put("S", Integer.parseInt(parts[0]));
                    majorGradePolicy.put("A", Integer.parseInt(parts[1]));
                    majorGradePolicy.put("B", Integer.parseInt(parts[2]));
                    majorGradePolicy.put("C", Integer.parseInt(parts[3]));
                    majorGradePolicy.put("D", Integer.parseInt(parts[4]));
                    majorGradePolicy.put("F", Integer.parseInt(parts[5]));
                    break;  // 첫 번째 줄만 읽어 처리
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return majorGradePolicy;
    }

    public static Map<String, Integer> loadSubGradePolicy(String fileName) {
        Map<String, Integer> subGradePolicy = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    subGradePolicy.put("A", Integer.parseInt(parts[0]));
                    subGradePolicy.put("B", Integer.parseInt(parts[1]));
                    subGradePolicy.put("C", Integer.parseInt(parts[2]));
                    subGradePolicy.put("D", Integer.parseInt(parts[3]));
                    subGradePolicy.put("F", Integer.parseInt(parts[4]));
                    break;  // 첫 번째 줄만 읽어 처리
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return subGradePolicy;
    }

    public static Map<String, String> loadMajorSubjectPolicy(String fileName) {
        Map<String, String> majorSubjectPolicy = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    majorSubjectPolicy.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return majorSubjectPolicy;
    }
}
