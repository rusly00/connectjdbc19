import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {
    public static void main(String[] args) {
        Connection conn = DBConnection.connect();
        if (conn == null) return;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter student Name: ");
            String name = sc.nextLine();

            String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();

            System.out.println("✅ Student added.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
