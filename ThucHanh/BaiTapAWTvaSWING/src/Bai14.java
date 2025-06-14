
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class Bai14 extends JFrame {
    private DrawPanel drawPanel;

    public Bai14() {
        setTitle("Bài 14");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel);

        setVisible(true);
    }

    class DrawPanel extends JPanel {
        private ArrayList<Point> controlPoints = new ArrayList<>();
        private CubicCurve2D curve;
        private float t = 0;
        private Timer timer;

        public DrawPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (controlPoints.size() < 4) {
                        controlPoints.add(e.getPoint());
                        repaint();
                        if (controlPoints.size() == 4) {
                            curve = new CubicCurve2D.Float(
                                    controlPoints.get(0).x, controlPoints.get(0).y,
                                    controlPoints.get(1).x, controlPoints.get(1).y,
                                    controlPoints.get(2).x, controlPoints.get(2).y,
                                    controlPoints.get(3).x, controlPoints.get(3).y
                            );
                            startAnimation();
                        }
                    }
                }
            });
        }

        private void startAnimation() {
            t = 0;
            timer = new Timer(30, e -> {
                t += 0.01;
                if (t > 1) t = 0;
                repaint();
            });
            timer.start();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Vẽ điểm điều khiển
            g2.setColor(Color.GRAY);
            for (Point p : controlPoints) {
                g2.fill(new Ellipse2D.Double(p.x - 3, p.y - 3, 6, 6));
            }

            // Vẽ đường Bezier
            if (curve != null) {
                g2.setColor(Color.BLUE);
                g2.draw(curve);

                // Tính vị trí chữ theo t
                Point2D pt = getBezierPoint(t, controlPoints);
                g2.setColor(Color.RED);
                g2.setFont(new Font("Serif", Font.BOLD, 18));
                g2.drawString("Vũ Bình", (float) pt.getX(), (float) pt.getY());
            }
        }

        private Point2D getBezierPoint(float t, ArrayList<Point> pts) {
            float x = (float) (
                    Math.pow(1 - t, 3) * pts.get(0).x +
                            3 * Math.pow(1 - t, 2) * t * pts.get(1).x +
                            3 * (1 - t) * t * t * pts.get(2).x +
                            t * t * t * pts.get(3).x
            );
            float y = (float) (
                    Math.pow(1 - t, 3) * pts.get(0).y +
                            3 * Math.pow(1 - t, 2) * t * pts.get(1).y +
                            3 * (1 - t) * t * t * pts.get(2).y +
                            t * t * t * pts.get(3).y
            );
            return new Point2D.Float(x, y);
        }
    }

    public static void main(String[] args) {
        new Bai14();
    }
}
