import java.util.Scanner;

public class Bai_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập N: ");
        int N = scanner.nextInt();
        scanner.close();

        // Bắt đầu đo thời gian
        long startTime = System.nanoTime();

        // Tính tổng các số từ 1 đến N
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        // Kết thúc đo thời gian
        long endTime = System.nanoTime();

        // Tính thời gian thực thi
        long executionTime = endTime - startTime;

        // Hiển thị kết quả
        System.out.println("Tổng từ 1 đến " + N + " là: " + sum);
        System.out.println("Thời gian thực thi: " + executionTime + " nanoseconds.");
    }
}
