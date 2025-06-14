import java.io.*;
import java.util.*;

public class Bai4 {
    public static void main(String[] args) throws IOException {
        int[][] matrix;
        int m, n;

        // 1. Đọc ma trận từ file
        try (Scanner sc = new Scanner(new File("matran.txt"))) {
            m = sc.nextInt();
            n = sc.nextInt();
            matrix = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (sc.hasNextInt()) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }
        }

        // 2. Tính toán
        int min = matrix[0][0];
        int max = matrix[0][0];
        int sum = 0;
        List<Integer> primes = new ArrayList<>();

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < min) min = val;
                if (val > max) max = val;
                if (isPrime(val)) primes.add(val);
                sum += val;
            }
        }

        // 3. Ghi kết quả ra file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ketqua.txt"))) {
            bw.write("Giá trị nhỏ nhất: " + min + "\n");
            bw.write("Giá trị lớn nhất: " + max + "\n");
            bw.write("Tổng các phần tử: " + sum + "\n");

            bw.write("Các số nguyên tố trong ma trận: ");
            for (int p : primes) {
                bw.write(p + " ");
            }
            bw.newLine();
        }

        System.out.println("Đã ghi kết quả ra ketqua.txt");
    }

    // Hàm kiểm tra số nguyên tố
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
