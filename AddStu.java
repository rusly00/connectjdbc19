import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStu {
    public static void main(String[] args) {
        // Connect to the database

        Connection conn = DBConnection.connect();
        if (conn == null) {
            System.out.println("Connection failed.");
            return;
        }

        try {
            // Get input from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            int student_id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter student Name: ");
            String name = scanner.nextLine();

            // SQL to insert student
            String sql = "INSERT INTO students (student_id, name) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student_id);
            pstmt.setString(2, name);

            // Execute insertion12
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Student added successfully.");
            }

            // Close connection
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Failed to insert student.");
            e.printStackTrace();
        }
    }
}
