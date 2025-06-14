public class Bai10 {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                printer.printNumber(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                printer.printEvenOdd();
            }
        });

        thread1.start();
        thread2.start();
    }
}

// Lớp chia sẻ dữ liệu và đồng bộ
class SharedPrinter {
    private int currentNumber = 0;
    private boolean ready = false;

    // Thread 1 gọi hàm này
    public synchronized void printNumber(int num) {
        while (ready) { // nếu chưa xử lý xong, đợi
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentNumber = num;
        System.out.println("Thread 1 → Số: " + currentNumber);
        ready = true;
        notify(); // báo cho thread 2
    }

    // Thread 2 gọi hàm này
    public synchronized void printEvenOdd() {
        while (!ready) { // nếu chưa có số mới, đợi
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String result = (currentNumber % 2 == 0) ? "Chẵn" : "Lẻ";
        System.out.println("Thread 2 → " + result);
        ready = false;
        notify(); // báo cho thread 1 tiếp tục
    }
}
