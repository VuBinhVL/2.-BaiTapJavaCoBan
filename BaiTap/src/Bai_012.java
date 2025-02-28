import java.util.Scanner;

public class Bai_012 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat();
        float x2 = x * x;
        float x4 = x2 * x2;
        float x6 = x2 * x4;
        System.out.println("x^6 = " + x6);
    }
}
