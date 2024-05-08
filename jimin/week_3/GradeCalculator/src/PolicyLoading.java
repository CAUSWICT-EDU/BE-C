import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PolicyLoading {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        Map<String, Integer> majorGradePolicy = loadMajorGradePolicy(currentDirectory + "\\src\\GradePolicy.txt");
        Map<String, Integer> subGradePolicy = loadSubGradePolicy(currentDirectory + "\\src\\GradePolicy.txt");
        Map<String, String> majorSubjectPolicy = loadMajorSubjectPolicy(currentDirectory + "\\src\\MajorSubjectPolicy.txt");

        // Map들이 제대로 로드되었는지 테스트
        System.out.println("Major Grade Policy: " + majorGradePolicy);
        System.out.println("Subject Grade Policy: " + subGradePolicy);
        System.out.println("Major Subject Policy: " + majorSubjectPolicy);
    }

    public static Map<String, Integer> loadMajorGradePolicy(String fileName) {
        Map<String, Integer> majorGradePolicy = new HashMap<>();
        // 전공 과목(필수 과목)에 대한 성적 커트라인 Map 생성

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    // 등급이 최소한 두 개는 넘어야 하므로 >= 2 (만약, 잘못된 정보가 들어올 때 걸러주는 역할도 수행)
                    // 여기서 등급 최소 개수를 강제할 수도 있음
                    majorGradePolicy.put("S", Integer.parseInt(parts[0])); // 성적 S를 받기 위한 컷 지정
                    majorGradePolicy.put("A", Integer.parseInt(parts[1])); // 성적 A를 받기 위한 컷 지정
                    majorGradePolicy.put("B", Integer.parseInt(parts[2])); // 이하 동일
                    majorGradePolicy.put("C", Integer.parseInt(parts[3]));
                    majorGradePolicy.put("D", Integer.parseInt(parts[4]));
                    majorGradePolicy.put("F", Integer.parseInt(parts[5]));
                    break;  // 세 번째 줄까지 가지 않도록 조절
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // 디버깅용
        }

        return majorGradePolicy;
    }

    public static Map<String, Integer> loadSubGradePolicy(String fileName) {
        Map<String, Integer> subGradePolicy = new HashMap<>();
        // 필수 과목이 아닌 과목에 대한 성적 커트라인 Map 생성

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    // 등급이 최소한 두 개는 넘어야 하므로 >= 2 (만약, 잘못된 정보가 들어올 때 걸러주는 역할도 수행)
                    // 여기서 등급 최소 개수를 강제할 수도 있음
                    subGradePolicy.put("A", Integer.parseInt(parts[0])); // 성적 A의 커트라인 설정
                    subGradePolicy.put("B", Integer.parseInt(parts[1])); // 성적 B의 커트라인 설정
                    subGradePolicy.put("C", Integer.parseInt(parts[2])); // 이하 동일
                    subGradePolicy.put("D", Integer.parseInt(parts[3]));
                    subGradePolicy.put("F", Integer.parseInt(parts[4]));
                    break;  // 첫 번째 줄만 읽어 처리
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // 디버깅용
        }

        return subGradePolicy;
    }

    public static Map<String, String> loadMajorSubjectPolicy(String fileName) {
        Map<String, String> majorSubjectPolicy = new HashMap<>();
        // 학과별 필수 과목을 지정하고 변경할 수 있도록 key를 전공 이름, value를 필수 과목 이름으로 하는 Map 생성

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    // txt파일의 구조가 "학과이름,필수과목" 형식이므로 split 하면 두 length가 2 이상
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    majorSubjectPolicy.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // 디버깅용
        }

        return majorSubjectPolicy;
    }
}
