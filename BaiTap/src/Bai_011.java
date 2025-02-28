import java.util.Scanner;

public class Bai_011 {
    public static void main(String[] args) {
        float x1, x2, x3, y1, y2, y3;
        System.out.print("Nhập x1: ");
        x1 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập y1: ");
        y1 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập x2: ");
        x2 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập y2: ");
        y2 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập x3: ");
        x3 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập y3: ");
        y3 = new Scanner(System.in).nextFloat();
        double a = Math.sqrt((Math.pow(x3-x2,2)) + Math.pow(y3 - y2,2));
        double b = Math.sqrt((Math.pow(x1-x2,2)) + Math.pow(y1 - y2,2));
        double c = Math.sqrt((Math.pow(x3-x1,2)) + Math.pow(y3 - y1,2));
        double p = (a + b + c)/2;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("Diện tích tam giác là: " + s);
    }
}
