
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TabSinhVienPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField tfMaSV, tfHoTen, tfLop, tfDiemTB;

    public TabSinhVienPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"MaSV", "HoTen", "Lop", "DiemTB"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(5, 2));
        tfMaSV = new JTextField(); tfHoTen = new JTextField();
        tfLop = new JTextField(); tfDiemTB = new JTextField();
        form.add(new JLabel("MaSV:")); form.add(tfMaSV);
        form.add(new JLabel("HoTen:")); form.add(tfHoTen);
        form.add(new JLabel("Lop:")); form.add(tfLop);
        form.add(new JLabel("DiemTB:")); form.add(tfDiemTB);

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
                tfMaSV.setText(model.getValueAt(row, 0).toString());
                tfHoTen.setText(model.getValueAt(row, 1).toString());
                tfLop.setText(model.getValueAt(row, 2).toString());
                tfDiemTB.setText(model.getValueAt(row, 3).toString());
            }
        });

        btnAdd.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfMaSV.getText());
                ps.setString(2, tfHoTen.getText());
                ps.setString(3, tfLop.getText());
                ps.setDouble(4, Double.parseDouble(tfDiemTB.getText()));
                ps.executeUpdate();
                loadData();
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnUpdate.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "UPDATE SinhVien SET HoTen=?, Lop=?, DiemTB=? WHERE MaSV=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfHoTen.getText());
                ps.setString(2, tfLop.getText());
                ps.setDouble(3, Double.parseDouble(tfDiemTB.getText()));
                ps.setString(4, tfMaSV.getText());
                ps.executeUpdate();
                loadData();
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnDelete.addActionListener(e -> {
            try (Connection conn = DatabaseConnect.getConnection()) {
                String sql = "DELETE FROM SinhVien WHERE MaSV=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfMaSV.getText());
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("MaSV"),
                        rs.getString("HoTen"),
                        rs.getString("Lop"),
                        rs.getDouble("DiemTB")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void resetForm() {
        tfMaSV.setText("");
        tfHoTen.setText("");
        tfLop.setText("");
        tfDiemTB.setText("");
    }
}
