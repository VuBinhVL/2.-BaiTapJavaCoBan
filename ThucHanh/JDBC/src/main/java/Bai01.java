import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Bai01 extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Bai01() {
        setTitle("Bài 1");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();
        setVisible(true);
    }

    // Kết nối CSDL và tải dữ liệu
    private void loadData() {

        try {
            // Bước 1: Kết nối CSDL
            Connection conn = DatabaseConnect.getConnection();

            // Bước 2: Thực thi truy vấn
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien");

            // Bước 3: Đọc thông tin cột
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            model.setColumnCount(0);
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnName(i));
            }

            // Bước 4: Đọc từng dòng dữ liệu
            model.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

            // Bước 5: Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Bai01();
    }
}
