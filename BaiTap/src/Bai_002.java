import java.util.Scanner;

public class Bai_002 {
    public static void main(String[] args) {
        float r;
        System.out.print("Nhập bán kính R: ");
        r = new Scanner(System.in).nextFloat();
        double dt = Math.PI*r*r;
        System.out.println("Diện tích hình tròn là: " + dt);
    }
}
