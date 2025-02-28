import java.util.Scanner;

public class Bai_023 {
    public static void main(String[] args) {
        int n;
        System.out.print("Nhập số nguyên dương n: ");
        n = new Scanner(System.in).nextInt();
        int hc = (n / 10) % 10;
        System.out.println("Chữ số hàng chục của " + n + " là: " + hc);

    }
}
