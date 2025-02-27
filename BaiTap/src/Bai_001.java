import java.util.Scanner;

public class Bai_001 {
    public static void main(String[] args) {
        float x1,y1,x2,y2;
        System.out.println("Nhập x1:");
        x1 = new Scanner(System.in).nextFloat();
        System.out.println("Nhập y1:");
        y1 = new Scanner(System.in).nextFloat();
        System.out.println("Nhập x2:");
        x2 = new Scanner(System.in).nextFloat();
        System.out.println("Nhập y2:");
        y2 = new Scanner(System.in).nextFloat();
        double kc = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        System.out.println("Khoảng cách giữa 2 điểm là: " + kc);
    }
}
