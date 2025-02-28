import java.util.Scanner;

public class Bai_019 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat() ;
        float x2 = x * x;
        float x4 = x2 * x2;
        float x8 = x4 * x4;
        float x12 = x8 * x4;
        float x13 = x12 * x;
        System.out.println("x13 = " + x13);
    }
}
