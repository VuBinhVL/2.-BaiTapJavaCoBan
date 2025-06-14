import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai10 extends JFrame implements ActionListener, ItemListener {
    private JLabel textLabel;

    // Menu components
    private JRadioButtonMenuItem font1, font2, font3;
    private JCheckBoxMenuItem boldItem, italicItem;
    private JMenuItem redItem, greenItem, blueItem, aboutItem, exitItem;

    public Bai10() {
        setTitle("Bài 10");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Label văn bản chính
        textLabel = new JLabel("Văn bản mẫu", SwingConstants.CENTER);
        textLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        add(textLabel, BorderLayout.CENTER);

        // ==== Menu Bar ====
        JMenuBar menuBar = new JMenuBar();

        // ==== FILE ====
        JMenu fileMenu = new JMenu("File");
        aboutItem = new JMenuItem("About");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);

        aboutItem.addActionListener(this);
        exitItem.addActionListener(this);

        // ==== FORMAT ====
        JMenu formatMenu = new JMenu("Format");

        // COLOR submenu
        JMenu colorMenu = new JMenu("Color");
        redItem = new JMenuItem("Đỏ");
        greenItem = new JMenuItem("Xanh lá");
        blueItem = new JMenuItem("Xanh dương");
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);

        // FONT submenu
        JMenu fontMenu = new JMenu("Font");
        font1 = new JRadioButtonMenuItem("Serif", true);
        font2 = new JRadioButtonMenuItem("SansSerif");
        font3 = new JRadioButtonMenuItem("Monospaced");

        ButtonGroup fontGroup = new ButtonGroup();
        fontGroup.add(font1);
        fontGroup.add(font2);
        fontGroup.add(font3);

        boldItem = new JCheckBoxMenuItem("Bold");
        italicItem = new JCheckBoxMenuItem("Italic");

        fontMenu.add(font1);
        fontMenu.add(font2);
        fontMenu.add(font3);
        fontMenu.addSeparator();
        fontMenu.add(boldItem);
        fontMenu.add(italicItem);

        font1.addActionListener(this);
        font2.addActionListener(this);
        font3.addActionListener(this);
        boldItem.addItemListener(this);
        italicItem.addItemListener(this);

        // Thêm Color & Font vào Format
        formatMenu.add(colorMenu);
        formatMenu.add(fontMenu);

        // Thêm File & Format vào menu bar
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Xử lý khi chọn menu thường
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == aboutItem) {
            JOptionPane.showMessageDialog(this, "Chương trình Menu Format Demo\nTác giả: Bạn");
        } else if (src == exitItem) {
            System.exit(0);
        } else if (src == redItem) {
            textLabel.setForeground(Color.RED);
        } else if (src == greenItem) {
            textLabel.setForeground(Color.GREEN);
        } else if (src == blueItem) {
            textLabel.setForeground(Color.BLUE);
        } else {
            updateFont(); // Khi đổi font
        }
    }

    // Xử lý khi chọn bold/italic
    @Override
    public void itemStateChanged(ItemEvent e) {
        updateFont(); // cập nhật lại font khi tick
    }

    // Hàm cập nhật kiểu chữ
    private void updateFont() {
        String fontName = "Serif";
        if (font2.isSelected()) fontName = "SansSerif";
        else if (font3.isSelected()) fontName = "Monospaced";

        int style = Font.PLAIN;
        if (boldItem.isSelected()) style += Font.BOLD;
        if (italicItem.isSelected()) style += Font.ITALIC;

        textLabel.setFont(new Font(fontName, style, 24));
    }

    public static void main(String[] args) {
        new Bai10();
    }
}
