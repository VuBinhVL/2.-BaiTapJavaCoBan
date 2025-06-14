import javax.swing.*;
import java.awt.*;

public class Bai04 extends JFrame {
    private JPanel panel;

    public Bai04() {
        setTitle("Bài 04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);

        //Pannel chứa các nút
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        add(panel);

        //Tạo các nút
        JButton btnLeft = new JButton("Trái");
        JButton btnRight = new JButton("Phải");
        JButton btnCenter = new JButton("Giữa");
        panel.add(btnLeft);
        panel.add(btnCenter);
        panel.add(btnRight);

        //Xử lý các sự kiện
        btnLeft.addActionListener(e -> changeAlignment(FlowLayout.LEFT));
        btnRight.addActionListener(e -> changeAlignment(FlowLayout.RIGHT));
        btnCenter.addActionListener(e -> changeAlignment(FlowLayout.CENTER));


        setVisible(true);
    }

    //Hàm thay đổi lề
    public void changeAlignment (int align)
    {
        panel.setLayout(new FlowLayout(align,10,10));
        panel.revalidate();  // cập nhật lại layout
        panel.repaint();
    }

    public static void main(String[] args) {
        new Bai04();
    }
}
