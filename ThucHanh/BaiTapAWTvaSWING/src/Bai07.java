import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai07 extends JFrame implements ActionListener {
    private JRadioButton redBtn, greenBtn, blueBtn;
    private ButtonGroup colorGroup;

    public Bai07() {
        setTitle("Bài 07");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        setLocationRelativeTo(null);

        //Tạo các radio Button
        redBtn = new JRadioButton("Red");
        greenBtn = new JRadioButton("Green");
        blueBtn = new JRadioButton("Blue");

        //Tạo groupButtton
        colorGroup = new ButtonGroup();
        colorGroup.add(redBtn);
        colorGroup.add(greenBtn);
        colorGroup.add(blueBtn);

        add(new JLabel("Chọn màu: "));
        add(redBtn);
        add(greenBtn);
        add(blueBtn);

        //Gắn sự kiện
        redBtn.addActionListener(this);
        greenBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Color intialColor = Color.WHITE;
        if (e.getSource() == redBtn){
            intialColor = Color.RED;
        }
        if (e.getSource() == greenBtn){
            intialColor = Color.GREEN;
        }
        if (e.getSource() == blueBtn){
            intialColor = Color.BLUE;
        }

        Color chooseColor = JColorChooser.showDialog(this, "Chọn màu", intialColor);
        if (chooseColor != null){
            getContentPane().setBackground(chooseColor);
        }
    }

    public static void main(String[] args) {
        new Bai07();
    }
}
