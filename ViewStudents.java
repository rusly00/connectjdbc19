import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudents {
    public static void main(String[] args) {
        Connection conn = DBConnection.connect();
        if (conn == null) return;

        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("📋 Student List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") + ", Name: " + rs.getString("name"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
