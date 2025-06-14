public class Bai8_2 implements Runnable {
    //Cách 2 triển khai Runnable
    private String name;

    public Bai8_2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500); // 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main cho cách 2
    public static void main(String[] args) {
        Runnable r1 = new Bai8_2("Runnable1");
        Runnable r2 = new Bai8_2("Runnable2");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        t1.start();
        t2.start();
    }
}
