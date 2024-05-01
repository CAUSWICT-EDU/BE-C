import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/goodschool?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "yjg753951!";

    public ArrayList<Student> selectList() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Student> list = null;
        String sql = "select * from student";
        try (Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
             Statement stmt = conn.createStatement();            //3. SQL 실행 통로 형성
             ResultSet rs = stmt.executeQuery(sql);
        ) {

            //5. sql 결과처리
            list = new ArrayList<>();
            while (rs.next()) {
                String stuName = rs.getString("name");
                String stuId = rs.getString("id");
                String stuMajor = rs.getString("major");
                String required = rs.getString("required");
                String stuMath = rs.getString("math");
                String stuKor = rs.getString("kor");

                Student dto = new Student(stuName, stuId, stuMajor, required, stuMath, stuKor);

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
}