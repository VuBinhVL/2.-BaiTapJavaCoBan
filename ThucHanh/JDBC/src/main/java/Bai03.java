
import javax.swing.*;

public class Bai03 extends JFrame {
    public Bai03() {
        setTitle("Bài 3");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Lớp", new TabLopPanel());
        tabs.add("Sinh Viên", new TabSinhVienPanel());

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai03   ();
    }
}
