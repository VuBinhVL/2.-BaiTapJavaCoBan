
import javax.swing.*;

public class Bai04 extends JFrame {
    public Bai04() {
        setTitle("Bài 4");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Lớp", new TabLopPanel());
        tabs.add("Sinh Viên", new TabSinhVienPanelBai04());

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai04   ();
    }
}
