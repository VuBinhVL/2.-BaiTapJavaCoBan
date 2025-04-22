import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape
{
    public abstract double getArea();

    public abstract String getName();
    @Override
    public String toString() {
        return String.format("%s - Diện tích: %,.0f", getName(), getArea());
    }

    public abstract void Input(Scanner sc);
}

class Rectangle extends Shape
{
    private double width;
    private double height;

    public Rectangle()
    {
        this.height = 1;
        this.width = 1;
    }

    public Rectangle (double w, double h)
    {
        width = w;
        height = h;
    }
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getName() {
        return "Hình chữ nhật";
    }

    @Override
    public void Input(Scanner sc) {
        while (true)
        {
            System.out.print("Nhập chiều dài: ");
            if (sc.hasNextDouble() && (height = sc.nextDouble()) > 0)
            {
                sc.nextLine();
                break;
            }
            else
            {
                System.out.println("Lỗi! Nhập số > 0.");
                sc.nextLine();
            }
        }

        while (true)
        {
            System.out.print("Nhập chiều rộng: ");
            if (sc.hasNextDouble() && (width = sc.nextDouble()) > 0)
            {
                sc.nextLine();
                break;
            }
            else
            {
                System.out.println("Lỗi! Nhập số > 0.");
                sc.nextLine();
            }
        }
    }
}

class Circle extends Shape
{
    private double radius;
    public Circle()
    {
        this.radius = 1;
    }

    public Circle (double r)
    {
        radius = r;
    }
    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

    @Override
    public String getName() {
        return "Hình tròn";
    }

    @Override
    public void Input(Scanner sc) {
        while (true)
        {
            System.out.print("Nhập bán kính: ");
            if (sc.hasNextDouble() && (radius = sc.nextDouble()) > 0)
            {
                sc.nextLine();
                break;
            }
            else
            {
                System.out.println("Lỗi! Nhập số > 0.");
                sc.nextLine();
            }
        }
    }
}
public class Bai_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> list = new ArrayList<>();
        int n;
        //Nhập số lượng hình
        while (true)
        {
            System.out.print("Nhập số lượng hình: ");
            if (sc.hasNextInt() && (n = sc.nextInt()) > 0)
            {
                sc.nextLine();
                break;
            }
            else
            {
                System.out.println("Lỗi! Nhập số nguyên dương.");
                sc.nextLine();
            }
        }

        //Nhập hình
        for (int i = 0; i< n; i++)
        {
            System.out.printf("Hình %d: \n", i + 1);
            System.out.print("Nhập loại hình (1. Hình chữ nhật, 2. Hình tròn): ");
            String choice = sc.nextLine();
            Shape shape = null;
            if (choice.equals("1"))
            {
                shape = new Rectangle();
            }
            else if (choice.equals("2"))
            {
                shape = new Circle();
            }
            else {
                System.out.println("Lựa chọn không phù hợp! Kết thúc");
                break;
            }
            shape.Input(sc);
            list.add(shape);
        }

        //Đếm số lượng hình và xuất hình có S lơ nhất
        int rectangleCount = 0, circleCount = 0;
        Shape maxAreaShape = list.get(0);
        for (Shape s: list) {
            if (s instanceof Rectangle)
                rectangleCount ++;
            else if (s instanceof Circle)
                circleCount ++;

            if (maxAreaShape.getArea() < s.getArea())
                maxAreaShape = s;
        }
        // Kết quả
        System.out.println("\n=== KẾT QUẢ ===");
        System.out.println("Tổng số hình chữ nhật: " + rectangleCount);
        System.out.println("Tổng số hình tròn: " + circleCount);
        System.out.println("Hình có diện tích lớn nhất: " + maxAreaShape);
    }
}
