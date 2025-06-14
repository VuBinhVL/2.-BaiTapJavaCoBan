import javax.swing.*;
import java.util.List;

public class Bai06 extends JFrame {
    public Bai06() {
        setTitle("Bài 06");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        String[] genres = {"Văn học", "Khoa học", "Lịch sử", "Công nghệ", "Thể thao", "Văn hóa"};

        //Tạo Jlist
        JList<String> bookList = new JList<>(genres);
        bookList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(bookList);
        scrollPane.setBounds(50, 30, 150, 120);
        add(scrollPane);

        //Nút submit
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(220, 50, 100, 30);
        add(btnSubmit);

        //Tạo sự kiện cho nút Submit
        btnSubmit.addActionListener(e -> {
            List<String> selectedBook = bookList.getSelectedValuesList();
            if (selectedBook.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Bạn chưa chọn thể loại sách nào!");
            }
            else
                JOptionPane.showMessageDialog(null,"Bạn đã chọn: \n" + selectedBook);
        });
        setVisible(true);

    }

    public static void main(String[] args) {
        new Bai06();
    }
}
