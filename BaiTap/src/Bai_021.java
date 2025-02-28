import java.util.Scanner;

public class Bai_021 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat() ;
        float x2 = x * x;
        float x4 = x2 * x2;
        float x8 = x4 * x4;
        float x16 = x8 * x8;
        float x15 = x16 / x;
        System.out.println("x15 = " + x15);
    }
}
