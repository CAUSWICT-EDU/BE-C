package domain;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/goodschool?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "yjg753951!";

    private ArrayList<StudentDTO> stuList = null;
    private ArrayList<CourseDTO> courList = null;

    public DAO() {
        selectList();
    }

    public ArrayList<StudentDTO> selectList() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from student";
        try (Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
             Statement stmt = conn.createStatement();            //3. SQL 실행 통로 형성
             ResultSet rs = stmt.executeQuery(sql);
        ) {

            //5. sql 결과처리
            stuList = new ArrayList<>();
            courList = new ArrayList<>();
            while (rs.next()) {
                String stuName = rs.getString("name");
                String stuId = rs.getString("id");
                String stuMajor = rs.getString("major");
                String required = rs.getString("required");
                String stuMathPoint = rs.getString("math");
                String stuKorPoint = rs.getString("kor");

                StudentDTO dtoStu = new StudentDTO(stuName, stuId, stuMajor, required, stuMathPoint, stuKorPoint);
                stuList.add(dtoStu);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stuList;
    }


    public ArrayList<StudentDTO> getStuList() {
        return stuList;
    }

    public ArrayList<CourseDTO> getCourList() {
        return courList;
    }
}