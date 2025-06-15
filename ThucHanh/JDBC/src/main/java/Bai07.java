
import java.sql.*;

public class Bai07 {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnect.getConnection()) {
            Statement stmt = conn.createStatement();

            System.out.println("1. Số sinh viên của từng lớp:");
            String sql1 = "SELECT Lop, COUNT(*) AS SoSV FROM SinhVien GROUP BY Lop";
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                System.out.printf("Lớp: %-10s | Số SV: %d\n", rs.getString("Lop"), rs.getInt("SoSV"));
            }

            System.out.println("\n2. Lớp có số sinh viên nhiều nhất:");
            String sql2 = "SELECT TOP 1 Lop, COUNT(*) AS SoSV FROM SinhVien GROUP BY Lop ORDER BY SoSV DESC";
            rs = stmt.executeQuery(sql2);
            if (rs.next()) {
                System.out.printf("Lớp: %s | Số SV: %d\n", rs.getString("Lop"), rs.getInt("SoSV"));
            }

            System.out.println("\n3. Lớp có sinh viên điểm TB cao nhất:");
            String sql3 = "SELECT TOP 1 Lop, MAX(DiemTB) AS DiemCaoNhat FROM SinhVien GROUP BY Lop ORDER BY DiemCaoNhat DESC";
            rs = stmt.executeQuery(sql3);
            if (rs.next()) {
                System.out.printf("Lớp: %s | Điểm TB cao nhất: %.2f\n", rs.getString("Lop"), rs.getDouble("DiemCaoNhat"));
            }

            System.out.println("\n4. Lớp có số SV không đạt (DiemTB < 5) nhiều nhất:");
            String sql4 = "SELECT TOP 1 Lop, COUNT(*) AS SoRot FROM SinhVien WHERE DiemTB < 5 GROUP BY Lop ORDER BY SoRot DESC";
            rs = stmt.executeQuery(sql4);
            if (rs.next()) {
                System.out.printf("Lớp: %s | Số SV không đạt: %d\n", rs.getString("Lop"), rs.getInt("SoRot"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        }
    }
}
