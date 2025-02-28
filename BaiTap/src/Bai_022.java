import java.util.Scanner;

public class Bai_022 {
    public static void main(String[] args) {
        int n;
        System.out.print("Nhập số nguyên dương n: ");
        n = new Scanner(System.in).nextInt();
        int dv = n % 10;
        System.out.println("Chữ số hàng đơn vị của " + n + " là :" + dv);
    }
}
