import java.util.Scanner;

public class Bai_013 {
    public static void main(String[] args) {
        float x;
        System.out.print("Nhập x: ");
        x = new Scanner(System.in).nextFloat() ;
        float x2 = x * x;
        float x4 = x2 * x2;
        float x6 = x4 * x2;
        float x7 = x6 * x;
        System.out.println("x7 = " + x7);

    }
}
