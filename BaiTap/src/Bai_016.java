import java.util.Scanner;

public class Bai_016 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat() ;
        float x2 = x * x;
        float x4 = x2 * x2;
        float x8 = x4 * x4;
        float x9 = x8 * x;
        System.out.println("x9 = " + x9);
    }
}
