import java.math.BigInteger;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        long a[] = new long[12];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng: ");
        for (int i = 0; i < 12; i++) {
            a[i] = scanner.nextLong();
        }

        BigInteger e = BigInteger.valueOf(13); // Số mũ e
        BigInteger n = BigInteger.valueOf(943); // Modulus n

        for (int i = 0; i < 12; i++) {
            BigInteger M = BigInteger.valueOf(a[i]);
            BigInteger C = M.modPow(e, n); // M^e mod n
            System.out.print(C + "\t");
        }

        scanner.close();
    }
}
