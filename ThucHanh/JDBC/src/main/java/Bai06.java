import java.sql.*;

public class Bai06 {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnect.getConnection()) {

            // Hiển thị các ràng buộc trong CSDL
            System.out.println("=== Danh sách Constraints ===");
            String queryConstraint = """
                SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
                FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
                WHERE CONSTRAINT_CATALOG = 'QLSV'
            """;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryConstraint);
            while (rs.next()) {
                System.out.printf("Bảng: %-10s | Ràng buộc: %-20s | Loại: %s\n",
                        rs.getString("TABLE_NAME"),
                        rs.getString("CONSTRAINT_NAME"),
                        rs.getString("CONSTRAINT_TYPE"));
            }

            // Hiển thị các stored procedure
            System.out.println("\n=== Danh sách Stored Procedures ===");
            String querySP = """
                SELECT name FROM sys.objects
                WHERE type = 'P' AND is_ms_shipped = 0
            """;
            rs = stmt.executeQuery(querySP);
            while (rs.next()) {
                System.out.println("Stored Procedure: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
