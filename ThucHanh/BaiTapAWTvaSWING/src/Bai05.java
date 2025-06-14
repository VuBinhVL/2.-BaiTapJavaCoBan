import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai05 extends JFrame implements ActionListener {
    private JButton btnNorth, btnSouth, btnEast, btnWest, btnCenter;

    public Bai05() {
        setTitle("Bài 05");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        //Khởi tạo các nút
        btnNorth = new JButton("Trên");
        btnSouth = new JButton("Dưới");
        btnEast = new JButton("Phải");
        btnWest = new JButton("Trái");
        btnCenter = new JButton("Giữa");

        //Thêm các nút vào
        add(BorderLayout.NORTH,btnNorth);
        add(BorderLayout.SOUTH,btnSouth);
        add(BorderLayout.EAST,btnEast);
        add(BorderLayout.WEST,btnWest);
        add(BorderLayout.CENTER,btnCenter);

        //Gắn sự kiện
        btnNorth.addActionListener(this);
        btnSouth.addActionListener(this);
        btnEast.addActionListener(this);
        btnWest.addActionListener(this);
        btnCenter.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Hiển thị tất cả các nút
        btnNorth.setVisible(true);
        btnSouth.setVisible(true);
        btnEast.setVisible(true);
        btnWest.setVisible(true);
        btnCenter.setVisible(true);

        //Ẩn nút được ấn
        Object source = e.getSource();
        if (source == btnNorth) {
            btnNorth.setVisible(false);
        }
        else if (source == btnSouth) {
            btnSouth.setVisible(false);
        }
        else if (source == btnEast) {
            btnEast.setVisible(false);
        }
        else if (source == btnWest) {
            btnWest.setVisible(false);
        }
        else if (source == btnCenter) {
            btnCenter.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Bai05();
    }
}
