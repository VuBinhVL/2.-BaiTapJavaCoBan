public class Bai9 {

    // Thread in số chẵn
    static class EvenThread extends Thread {
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println("Thread1: " + i);
                }
            }
        }
    }

    // Thread in số lẻ
    static class OddThread extends Thread {
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 != 0) {
                    System.out.println("Thread2: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        EvenThread thread1 = new EvenThread();
        OddThread thread2 = new OddThread();

        thread1.start();       // Bắt đầu thread in số chẵn

        try {
            thread1.join();    // Đợi cho đến khi thread1 kết thúc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();       // Bắt đầu thread in số lẻ
    }
}
