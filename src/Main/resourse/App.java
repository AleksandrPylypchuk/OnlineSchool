package Main.resourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {


        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost/mydatabase";
            String user = "root"; //
            String password = "Qwert12345!";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement stmt = con.createStatement()) {

                String sql = "CREATE TABLE courses (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, description TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE students (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE teachers (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE course_student (course_id INT NOT NULL, student_id INT NOT NULL, PRIMARY KEY (course_id, student_id), FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE, FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE course_teacher (course_id INT NOT NULL, teacher_id INT NOT NULL, PRIMARY KEY (course_id, teacher_id), FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE, FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON DELETE CASCADE)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE lessons (id INT PRIMARY KEY AUTO_INCREMENT, course_id INT NOT NULL, name VARCHAR(255) NOT NULL, description TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE grades (id INT PRIMARY KEY AUTO_INCREMENT, lesson_id INT NOT NULL, student_id INT NOT NULL, grade FLOAT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE, FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE)";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE logs (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), message TEXT, stacktrace TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
                stmt.executeUpdate(sql);

                System.out.println("Tables connected");
            } catch (SQLException e) {
                System.err.println("Database connection error: " + e.getMessage());
            }
        }
    }


