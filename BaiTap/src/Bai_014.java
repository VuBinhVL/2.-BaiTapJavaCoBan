import java.util.Scanner;

public class Bai_014 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat() ;
        float x2 = x * x;
        float x4 = x2 * x2;
        float x8 = x4 * x4;
        float x16 = x8 * x8;
        float x32 = x16 * x16;
        System.out.println("x32 = " + x32);

    }
}
