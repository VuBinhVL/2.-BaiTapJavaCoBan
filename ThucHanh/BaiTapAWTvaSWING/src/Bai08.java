import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class Bai08 extends JFrame {
    private JLabel imageLabel;

    public Bai08() {
        setTitle("Bài 08");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        //Hiển thị ảnh
        imageLabel = new JLabel("Chưa chọn ảnh",SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        //Nút chọn ảnh
        JButton chooseFile = new JButton("Chọn ảnh");
        add(chooseFile, BorderLayout.SOUTH);

        //Gắn sự kiện
        chooseFile.addActionListener(e -> openChooseFileImage());

        setVisible(true);
    }

    public void openChooseFileImage()
    {
        JFileChooser fileChooser = new JFileChooser();
        //Bộ lọc chỉ chọn ảnh
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg", "gif");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Tạo icon từ ảnh
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());

            // Resize ảnh nếu quá to
            Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            // Gán icon cho label
            imageLabel.setText(""); // Xóa chữ cũ
            imageLabel.setIcon(icon);
        }
    }

    public static void main(String[] args) {
        new Bai08();
    }
}
