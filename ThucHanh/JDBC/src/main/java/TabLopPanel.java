
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TabLopPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField tfMaLop, tfTenLop, tfCVHT;

    public TabLopPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"MaLop", "TenLop", "CVHT"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(4, 2));
        tfMaLop = new JTextField(); tfTenLop = new JTextField(); tfCVHT = new JTextField();
        form.add(new JLabel("MaLop:")); form.add(tfMaLop);
        form.add(new JLabel("TenLop:")); form.add(tfTenLop);
        form.add(new JLabel("CVHT:")); form.add(tfCVHT);

        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Thêm"), btnUpdate = new JButton("Sửa"),
                btnDelete = new JButton("Xóa"), btnReset = new JButton("Reset");
        buttons.add(btnAdd); buttons.add(btnUpdate); buttons.add(btnDelete); buttons.add(btnReset);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(form, BorderLayout.CENTER);
        bottom.add(buttons, BorderLayout.SOUTH);
        add(bottom, BorderLayout.SOUTH);

        loadData();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfMaLop.setText(model.getValueAt(row, 0).toString());
                tfTenLop.setText(model.getValueAt(row, 1).toString());
                tfCVHT.setText(model.getValueAt(row, 2).toString());
            }
        });

        btnAdd.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "INSERT INTO Lop VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfMaLop.getText());
                ps.setString(2, tfTenLop.getText());
                ps.setString(3, tfCVHT.getText());
                ps.executeUpdate();
                loadData();
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnUpdate.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "UPDATE Lop SET TenLop=?, CVHT=? WHERE MaLop=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfTenLop.getText());
                ps.setString(2, tfCVHT.getText());
                ps.setString(3, tfMaLop.getText());
                ps.executeUpdate();
                loadData();
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnDelete.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "DELETE FROM Lop WHERE MaLop=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfMaLop.getText());
                ps.executeUpdate();
                loadData();
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnReset.addActionListener(e -> resetForm());
    }

    private void loadData() {
        model.setRowCount(0);
        try (Connection conn = DatabaseConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Lop")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("MaLop"),
                        rs.getString("TenLop"),
                        rs.getString("CVHT")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void resetForm() {
        tfMaLop.setText("");
        tfTenLop.setText("");
        tfCVHT.setText("");
    }
}
