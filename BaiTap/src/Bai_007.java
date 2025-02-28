import java.util.Scanner;

public class Bai_007 {
    public static void main(String[] args) {
        float f;
        System.out.print("Nhập độ F: ");
        f = new Scanner(System.in).nextFloat();
        float c = ((float) 5 / 9) * (f - 32);
        System.out.println("Độ C là: " + c);
    }
}
