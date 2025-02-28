import java.util.Scanner;

public class Bai_006 {
    public static void main(String[] args) {
        float c;
        System.out.print("Nhập độ C: ");
        c = new Scanner(System.in).nextFloat();
        float f = ((9 * c) / 5 ) + 32;
        System.out.println("Độ F là: " + f);
    }
}
