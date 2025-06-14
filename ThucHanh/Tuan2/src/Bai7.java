import java.io.*;
import java.util.*;

public class Bai7 {
    static final String FILE_NAME = "Number.txt";
    static final Object LOCK = new Object();  // Dùng làm khóa đồng bộ

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 1000; i <= 10000; i++) {
                    if (isPrime(i)) {
                        synchronized (LOCK) {
                            bw.write(i + "\n");
                            bw.flush();  // Ghi ngay ra file
                            LOCK.notify();  // Báo cho thread đọc
                        }

                        // Chờ một chút để dễ quan sát output (không bắt buộc)
                        Thread.sleep(10);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    try {
                        LOCK.wait();  // Chờ writer ghi
                        // Sau mỗi lần được báo, đọc file
                        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                            System.out.println("Nội dung hiện tại của file:");
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                            System.out.println("--------");
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        readerThread.start();
        writerThread.start();
    }

    // Kiểm tra số nguyên tố
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) return false;
        return true;
    }
}
