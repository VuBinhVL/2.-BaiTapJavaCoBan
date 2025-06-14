
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Bai13 extends JFrame {
    private DrawPanel drawPanel;
    private JComboBox<String> shapeBox;
    private JButton penColorBtn, fillColorBtn;
    private JCheckBox fillCheck;
    private Color penColor = Color.BLACK, fillColor = Color.LIGHT_GRAY;
    private boolean fillEnabled = false;
    private String currentShape = "Line";

    public Bai13() {
        setTitle("Bài 13");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();

        shapeBox = new JComboBox<>(new String[] {"Line", "Rectangle", "Circle", "Ellipse", "Polygon", "Curve"});
        shapeBox.addActionListener(e -> currentShape = (String) shapeBox.getSelectedItem());

        penColorBtn = new JButton("Pen Color");
        penColorBtn.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Chọn màu viền", penColor);
            if (c != null) penColor = c;
        });

        fillColorBtn = new JButton("Fill Color");
        fillColorBtn.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Chọn màu tô", fillColor);
            if (c != null) fillColor = c;
        });

        fillCheck = new JCheckBox("Fill");
        fillCheck.addActionListener(e -> fillEnabled = fillCheck.isSelected());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Shape:"));
        topPanel.add(shapeBox);
        topPanel.add(penColorBtn);
        topPanel.add(fillColorBtn);
        topPanel.add(fillCheck);

        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    class DrawPanel extends JPanel {
        private Point start, end;
        private ArrayList<Point> pathPoints = new ArrayList<>();

        public DrawPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    start = e.getPoint();
                    if (currentShape.equals("Curve")) {
                        pathPoints.clear();
                        pathPoints.add(start);
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    end = e.getPoint();
                    if (currentShape.equals("Curve")) {
                        repaint();
                    } else {
                        drawShape(start, end);
                    }
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    if (currentShape.equals("Curve")) {
                        pathPoints.add(e.getPoint());
                        repaint();
                    } else {
                        end = e.getPoint();
                        repaint();
                    }
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (currentShape.equals("Curve") && pathPoints.size() > 1) {
                g2.setColor(penColor);
                for (int i = 1; i < pathPoints.size(); i++) {
                    Point p1 = pathPoints.get(i - 1);
                    Point p2 = pathPoints.get(i);
                    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            } else if (start != null && end != null) {
                Shape shape = getShape(start, end);
                if (shape != null) {
                    if (fillEnabled) {
                        g2.setColor(fillColor);
                        g2.fill(shape);
                    }
                    g2.setColor(penColor);
                    g2.draw(shape);
                }
            }
        }

        private Shape getShape(Point p1, Point p2) {
            int x = Math.min(p1.x, p2.x);
            int y = Math.min(p1.y, p2.y);
            int w = Math.abs(p2.x - p1.x);
            int h = Math.abs(p2.y - p1.y);

            switch (currentShape) {
                case "Line":
                    return new Line2D.Float(p1, p2);
                case "Rectangle":
                    return new Rectangle(x, y, w, h);
                case "Circle":
                    int size = Math.max(w, h);
                    return new Ellipse2D.Float(x, y, size, size);
                case "Ellipse":
                    return new Ellipse2D.Float(x, y, w, h);
                case "Polygon":
                    int[] xs = {p1.x, p2.x, p1.x - (p2.x - p1.x), p2.x, p1.x};
                    int[] ys = {p1.y, p2.y, p2.y + 20, p1.y - 40, p2.y};
                    return new Polygon(xs, ys, xs.length);
            }
            return null;
        }

        private void drawShape(Point p1, Point p2) {
            this.start = p1;
            this.end = p2;
            repaint();
        }
    }

    public static void main(String[] args) {
        new Bai13();
    }
}
