public class Bai8_1 extends Thread {
    //Cách 1 kế thua Thread
    private String name;

    public Bai8_1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500); // 500ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main cho cách 1
    public static void main(String[] args) {
        Bai8_1 t1 = new Bai8_1("Thread1");
        Bai8_1 t2 = new Bai8_1("Thread2");

        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        t1.start();
        t2.start();
    }
}
