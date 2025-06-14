import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai09 extends JFrame implements ActionListener {
    private JTextField textField;
    private JRadioButton normalBtn, boldBtn, italicBtn, boldItalicBtn;
    private ButtonGroup styleGroup;

    public Bai09() {
        setTitle("Bài 9");
        setSize(400, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // TextField
        textField = new JTextField("Kiểu chữ sẽ thay đổi ở đây");
        textField.setBounds(50, 20, 300, 30);
        add(textField);

        // Radio buttons
        normalBtn = new JRadioButton("Thường");
        boldBtn = new JRadioButton("Bôi đậm");
        italicBtn = new JRadioButton("In nghiêng");
        boldItalicBtn = new JRadioButton("Đậm + Nghiêng");

        // Đặt vị trí
        normalBtn.setBounds(50, 60, 100, 25);
        boldBtn.setBounds(50, 90, 100, 25);
        italicBtn.setBounds(200, 60, 120, 25);
        boldItalicBtn.setBounds(200, 90, 150, 25);

        // Nhóm lại để chỉ chọn 1
        styleGroup = new ButtonGroup();
        styleGroup.add(normalBtn);
        styleGroup.add(boldBtn);
        styleGroup.add(italicBtn);
        styleGroup.add(boldItalicBtn);

        // Thêm vào frame
        add(normalBtn);
        add(boldBtn);
        add(italicBtn);
        add(boldItalicBtn);

        // Gắn sự kiện
        normalBtn.addActionListener(this);
        boldBtn.addActionListener(this);
        italicBtn.addActionListener(this);
        boldItalicBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int style = Font.PLAIN;

        if (boldBtn.isSelected()) {
            style = Font.BOLD;
        } else if (italicBtn.isSelected()) {
            style = Font.ITALIC;
        } else if (boldItalicBtn.isSelected()) {
            style = Font.BOLD + Font.ITALIC;
        }

        // Cập nhật lại font
        textField.setFont(new Font("Arial", style, 16));
    }

    public static void main(String[] args) {
        new Bai09();
    }
}
