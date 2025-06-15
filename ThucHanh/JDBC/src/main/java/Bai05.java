
import javax.swing.*;

public class Bai05 extends JFrame {
    public Bai05() {
        setTitle("Bài 5");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Lớp", new TabLopPanel());
        tabs.add("Sinh Viên", new TabSinhVienPanelBai05());

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai05   ();
    }
}
