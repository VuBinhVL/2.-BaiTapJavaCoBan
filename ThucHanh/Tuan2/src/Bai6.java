import java.util.ArrayList;
import java.util.List;

public class Bai6 {

    // Danh sách lưu số nguyên tố
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i <= 1_000_000; i++) {
                if (isPrime(i)) {
                    synchronized (primes) {
                        primes.add(i);
                    }
                }
            }
            System.out.println("Thread 1: Đã tìm xong số nguyên tố");
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join(); // chờ thread1 hoàn thành
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long sum = 0;
            synchronized (primes) {
                for (int p : primes) {
                    sum += p;
                }
            }
            System.out.println("Thread 2: Tổng các số nguyên tố là: " + sum);
        });

        // Khởi động cả 2 luồng
        thread1.start();
        thread2.start();
    }

    // Hàm kiểm tra số nguyên tố
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
