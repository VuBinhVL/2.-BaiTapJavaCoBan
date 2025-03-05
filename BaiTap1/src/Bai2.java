import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        float a, b, c;
        double x1, x2;
        System.out.println("Phương trình bậc 2: ax^2 + bx + c = 0");
        System.out.print("Nhập a: ");
        a = new Scanner(System.in).nextFloat();
        System.out.print("Nhập b: ");
        b = new Scanner(System.in).nextFloat();
        System.out.print("Nhập c: ");
        c = new Scanner(System.in).nextFloat();
        float delta = b * b - 4 * a * c;
        if(delta < 0 )
        {
            System.out.println("Phương trình vô nghiệm");
        }
        else if (delta == 0)
        {
            x1 = -b / (2 * a );
            System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + x1);
        }
        else
        {
            x1 = (-b + Math.sqrt(delta))/ ( 2 * a );
            x2 = (-b - Math.sqrt(delta))/ ( 2 * a );
            System.out.println("Phương trình có 2 nghiệm: x1 = " + x1 + " x2 =" + x2);
        }
    }
}
