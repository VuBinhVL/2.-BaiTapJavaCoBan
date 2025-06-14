import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bai02 extends JFrame  implements KeyListener {
    private JLabel label;
    public Bai02() {
        setTitle("Bài 2");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        label = new JLabel("Ấn phím bất kỳ ....");
        label.setBounds(150, 140, 200, 30);
        add(label);

        //Xừ lý sự kiện
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String key = KeyEvent.getKeyText(keyCode);
        label.setText("Bạn vừa ấn: " + key);
    }

    public static void main(String[] args) {
        new Bai02();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
