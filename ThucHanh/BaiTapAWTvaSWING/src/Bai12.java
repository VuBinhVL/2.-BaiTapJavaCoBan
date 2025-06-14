import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Bai12 extends JFrame {
    private JSlider radiusSlider;
    private DrawPanel drawPanel;
    private int radius = 50;

    public Bai12() {
        setTitle("Bài 12");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo slider
        radiusSlider = new JSlider(10, 200, radius);
        radiusSlider.setMajorTickSpacing(30);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);

        // Gắn sự kiện slider
        radiusSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                radius = radiusSlider.getValue();
                drawPanel.repaint(); // vẽ lại khi thay đổi
            }
        });

        // Panel vẽ hình tròn
        drawPanel = new DrawPanel();

        add(drawPanel, BorderLayout.CENTER);
        add(radiusSlider, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Lớp con để vẽ hình tròn
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            int diameter = radius * 2;
            g.setColor(Color.PINK);
            g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
        }
    }

    public static void main(String[] args) {
        new Bai12();
    }
}
