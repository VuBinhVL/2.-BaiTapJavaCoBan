import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Bai11 extends JFrame {
    public Bai11() {
        setTitle("Bài 11");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new StarPanel());
        setVisible(true);
    }

    // Panel vẽ ngôi sao
    class StarPanel extends JPanel {
        Random rand = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.LIGHT_GRAY);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 180; // bán kính vòng tròn
            int numStars = 20;

            for (int i = 0; i < numStars; i++) {
                // Tính góc quay và vị trí mỗi ngôi sao
                double angle = 2 * Math.PI * i / numStars;
                int x = (int) (centerX + radius * Math.cos(angle));
                int y = (int) (centerY + radius * Math.sin(angle));

                // Tạo transform để xoay sao quanh chính giữa
                AffineTransform old = g2d.getTransform();
                g2d.translate(x, y);
                g2d.rotate(angle);

                // Đặt màu ngẫu nhiên
                g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

                // Vẽ ngôi sao tại gốc toạ độ (sẽ được dịch + xoay)
                drawStar(g2d, 0, 0, 30, 15);

                g2d.setTransform(old); // Khôi phục transform cũ
            }
        }

        // Hàm vẽ ngôi sao 5 cánh tại (x, y) với bán kính ngoài và trong
        private void drawStar(Graphics2D g, int x, int y, int outerR, int innerR) {
            Polygon star = new Polygon();
            for (int i = 0; i < 10; i++) {
                double angle = Math.PI / 5 * i;
                int r = (i % 2 == 0) ? outerR : innerR;
                int xi = (int) (x + r * Math.cos(angle));
                int yi = (int) (y + r * Math.sin(angle));
                star.addPoint(xi, yi);
            }
            g.fillPolygon(star);
        }
    }

    public static void main(String[] args) {
        new Bai11();
    }
}
