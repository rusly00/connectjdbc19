import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/Student";
        String user = "root"; // 🔁 change if needed
        String password = "root"; // 🔁 change if needed

        try {
            // Load driver (optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database!");
            return conn;

        } catch (Exception e) {
            System.out.println("❌ Connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
