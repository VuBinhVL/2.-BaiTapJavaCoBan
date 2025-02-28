import java.util.Scanner;

public class Bai_005 {
    public static void main(String[] args) {
        float r;
        System.out.printf("Nhập bán kính hình cầu: ");
        r = new Scanner(System.in).nextFloat();
        double v = (4 * Math.PI * r * r * r ) / 3;
        System.out.println("Thể tích hình cầu là:" + v);
    }
}
