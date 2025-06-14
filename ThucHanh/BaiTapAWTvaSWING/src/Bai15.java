
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.io.File;
import java.util.*;

public class Bai15 extends JFrame {
    private FlamePanel flamePanel;
    private JSpinner spinner;

    public Bai15() {
        setTitle("Bài 15");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        flamePanel = new FlamePanel();

        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JButton showBtn = new JButton("Hiển thị");

        showBtn.addActionListener(e -> flamePanel.setFlameCount((int) spinner.getValue()));

        JPanel top = new JPanel();
        top.add(new JLabel("Số lượng ngọn lửa (1–10):"));
        top.add(spinner);
        top.add(showBtn);

        add(top, BorderLayout.NORTH);
        add(flamePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    class FlamePanel extends JPanel {
        private int flameCount = 1;
        private ArrayList<Flame> flames = new ArrayList<>();
        private BufferedImage spriteSheet;
        private int frameWidth = 64, frameHeight = 64;
        private int rows = 6, cols = 6;
        private Timer timer;
        private Random rand = new Random();

        public FlamePanel() {
            setBackground(Color.BLACK);
            try {
                spriteSheet = ImageIO.read(new File("flame_sprite.png"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không thể tải hình ảnh ngọn lửa.");
            }

            timer = new Timer(100, e -> {
                for (Flame flame : flames) {
                    flame.nextFrame();
                }
                repaint();
            });
            timer.start();
        }

        public void setFlameCount(int count) {
            flames.clear();
            for (int i = 0; i < count; i++) {
                int x = rand.nextInt(getWidth() - frameWidth);
                int y = rand.nextInt(getHeight() - frameHeight - 50) + 30;
                flames.add(new Flame(x, y));
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (spriteSheet == null) return;

            Graphics2D g2 = (Graphics2D) g;
            for (Flame flame : flames) {
                int fx = flame.frame % cols;
                int fy = flame.frame / cols;
                int sx = fx * frameWidth;
                int sy = fy * frameHeight;
                g2.drawImage(spriteSheet, flame.x, flame.y, flame.x + frameWidth, flame.y + frameHeight,
                        sx, sy, sx + frameWidth, sy + frameHeight, null);
            }
        }

        class Flame {
            int x, y;
            int frame = 0;

            public Flame(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void nextFrame() {
                frame = (frame + 1) % (rows * cols);
            }
        }
    }

    public static void main(String[] args) {
        new Bai15();
    }
}
