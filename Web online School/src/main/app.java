package Main.resourse;

import java.sql.*;

public class App {


    public static void main(String[] args) {

        spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
        spring.datasource.username=dbuser
        spring.datasource.password=dbpass
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver

        try (Connection con = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = con.prepareCall("{call select_from_table(?)}")) {

            stmt.setString(1, "courses");
            ResultSet rs = stmt.executeQuery();
            stmt.setString(1, "courses");
            stmt.executeUpdate();

            stmt.setString(1, "students");
            stmt.executeUpdate();

            stmt.setString(1, "teachers");
            stmt.executeUpdate();

            stmt.setString(1, "course_student");
            stmt.executeUpdate();

            stmt.setString(1, "course_teacher");
            stmt.executeUpdate();

            stmt.setString(1, "lessons");
            stmt.executeUpdate();

            stmt.setString(1, "grades");
            stmt.executeUpdate();

            stmt.setString(1, "logs");
            stmt.executeUpdate();

            System.out.println("Tables connected");
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }

    }
}


