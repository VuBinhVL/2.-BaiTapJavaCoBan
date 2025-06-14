import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai03 extends JFrame  {
    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JButton copyButton = new JButton();

    public Bai03() {
        setTitle("Bài 03");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Text Area 1
        Label label1 = new Label("Text Area 1");
        label1.setBounds(30, 5, 200, 20);
        add(label1);
        textArea1 = new JTextArea();
        textArea1.setBounds(30, 30, 200, 100);
        add(textArea1);

        //Text Area 2
        Label label2 = new Label("Text Area 2");
        label2.setBounds(260, 5, 200, 20);
        add(label2);
        textArea2 = new JTextArea();
        textArea2.setBounds(260, 30, 200, 100);
        add(textArea2);

        //Copy Button
        copyButton = new JButton("Copy 1 -> 2");
        copyButton.setBounds(190, 150, 100, 30);
        add(copyButton);

        //Xử lý sự kiện
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedText1 = textArea1.getSelectedText();
                if (selectedText1 == null || selectedText1.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn văn bản để copy");
                }
                else  {
                    textArea2.setText(selectedText1);
                }

            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new Bai03();
    }
}
