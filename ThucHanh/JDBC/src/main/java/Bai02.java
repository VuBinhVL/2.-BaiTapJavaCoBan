import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Bai02 extends JFrame {
    private JTextArea textArea;

    public Bai02() {
        setTitle("Bài 2");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        loadTables();

        setVisible(true);
    }

    private void loadTables() {
        try (Connection conn = DatabaseConnect.getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(conn.getCatalog(), "dbo", "%", new String[]{"TABLE"});

            textArea.setText("Các bảng trong CSDL QLSV:\n\n");
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                textArea.append("- " + tableName + "\n");
            }

        } catch (SQLException e) {
            textArea.setText("Lỗi kết nối CSDL: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Bai02();
    }
}
