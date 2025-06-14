import javax.swing.*;

public class Bai01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bài 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);

        String ten = JOptionPane.showInputDialog("Nhập tên của bạn: ");
        JLabel label = new JLabel("Xin chào " + ten);
        label.setBounds(150, 140, 200, 30);
        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
