
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TabSinhVienPanelBai05 extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField tfMaSV, tfHoTen, tfLop, tfDiemTB;
    private JComboBox<String> cbSearchType;
    private JPanel searchPanel;
    private JTextField tfSearch1, tfSearch2;
    private JRadioButton rbAsc, rbDesc;

    public TabSinhVienPanelBai05() {
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

        // Search Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cbSearchType = new JComboBox<>(new String[]{"-- Chọn tiêu chí --", "Mã SV", "Họ tên", "Lớp", "Điểm TB"});
        tfSearch1 = new JTextField(10);
        tfSearch2 = new JTextField(10);
        JButton btnSearch = new JButton("Tìm");
        searchPanel = new JPanel();
        searchPanel.add(tfSearch1); // Mặc định
        topPanel.add(new JLabel("Tìm kiếm theo:"));
        topPanel.add(cbSearchType);
        topPanel.add(searchPanel);
        topPanel.add(btnSearch);

        // Sort Panel
        JPanel sortPanel = new JPanel();
        rbAsc = new JRadioButton("Tăng dần");
        rbDesc = new JRadioButton("Giảm dần");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbAsc); bg.add(rbDesc);
        sortPanel.add(new JLabel("Sắp xếp theo điểm:"));
        sortPanel.add(rbAsc); sortPanel.add(rbDesc);

        rbAsc.addActionListener(e -> loadData("ASC"));
        rbDesc.addActionListener(e -> loadData("DESC"));

        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.add(topPanel, BorderLayout.NORTH);
        topWrapper.add(sortPanel, BorderLayout.SOUTH);
        add(topWrapper, BorderLayout.NORTH);

        cbSearchType.addActionListener(e -> updateSearchInputs());
        btnSearch.addActionListener(e -> performSearch());

        loadData("");

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
                loadData("");
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
                loadData("");
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
                loadData("");
                resetForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnReset.addActionListener(e -> resetForm());
    }

    private void updateSearchInputs() {
        searchPanel.removeAll();
        tfSearch1.setText(""); tfSearch2.setText("");

        String option = cbSearchType.getSelectedItem().toString();
        if (option.equals("Điểm TB")) {
            searchPanel.add(new JLabel("Từ:"));
            searchPanel.add(tfSearch1);
            searchPanel.add(new JLabel("Đến:"));
            searchPanel.add(tfSearch2);
        } else if (!option.equals("-- Chọn tiêu chí --")) {
            searchPanel.add(tfSearch1);
        }
        searchPanel.revalidate();
        searchPanel.repaint();
    }

    private void performSearch() {
        model.setRowCount(0);
        String option = cbSearchType.getSelectedItem().toString();
        String sql = "";
        try (Connection conn = DatabaseConnect.getConnection()) {
            PreparedStatement ps = null;
            if (option.equals("Mã SV")) {
                sql = "SELECT * FROM SinhVien WHERE MaSV LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + tfSearch1.getText() + "%");
            } else if (option.equals("Họ tên")) {
                sql = "SELECT * FROM SinhVien WHERE HoTen LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + tfSearch1.getText() + "%");
            } else if (option.equals("Lớp")) {
                sql = "SELECT * FROM SinhVien WHERE Lop LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + tfSearch1.getText() + "%");
            } else if (option.equals("Điểm TB")) {
                sql = "SELECT * FROM SinhVien WHERE DiemTB BETWEEN ? AND ?";
                ps = conn.prepareStatement(sql);
                ps.setDouble(1, Double.parseDouble(tfSearch1.getText()));
                ps.setDouble(2, Double.parseDouble(tfSearch2.getText()));
            }

            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getString("MaSV"),
                            rs.getString("HoTen"),
                            rs.getString("Lop"),
                            rs.getDouble("DiemTB")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Điểm TB phải là số.");
        }
    }

    private void loadData(String order) {
        model.setRowCount(0);
        String sql = "SELECT * FROM SinhVien";
        if (order.equals("ASC")) sql += " ORDER BY DiemTB ASC";
        if (order.equals("DESC")) sql += " ORDER BY DiemTB DESC";
        try (Connection conn = DatabaseConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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
