import java.util.concurrent.*;

public class Bai11 {
    public static void main(String[] args) throws InterruptedException {
        int lower = 1;
        int upper = 1_000_000;
        int numberOfThreads = 8; // có thể điều chỉnh tùy CPU
        int rangePerThread = (upper - lower + 1) / numberOfThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int start = lower + i * rangePerThread;
            int end = (i == numberOfThreads - 1) ? upper : (start + rangePerThread - 1);

            executor.submit(new PrimeTask(start, end));
        }

        executor.shutdown(); // ngừng nhận task mới

        executor.awaitTermination(1, TimeUnit.HOURS); // chờ các thread hoàn tất
        System.out.println("Đã hoàn thành kiểm tra số nguyên tố.");
    }
}

// Task kiểm tra số nguyên tố trong một khoảng
class PrimeTask implements Runnable {
    private int start, end;

    public PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
