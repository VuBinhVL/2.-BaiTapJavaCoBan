class PrinterNumber {
    boolean isPrintNumber = false;
    int number = 1;

    public synchronized void printNumber() {
        while (number <= 100) {
            if (isPrintNumber) {
                try {
                    wait();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Thread: " + number);
            isPrintNumber = true;
            notify(); //Đánh thức thread 2;
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public synchronized void printCategoryNumber()
    {
        while (number <= 100)
        {
            if (!isPrintNumber) {
                try {
                    wait();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            if (number % 2 == 0) {
                System.out.println(" - chẵn" );
            }
            else
            {
                System.out.println(" - lẻ" );
            }
            number ++;
            isPrintNumber = false;
            notify();
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Thread_Bai_3 {
    public static void main(String[] args) {
        PrinterNumber printerNumber = new PrinterNumber();
        Thread th1 = new Thread(() -> printerNumber.printNumber());
        Thread th2 = new Thread(() -> printerNumber.printCategoryNumber());
        th1.start();
        th2.start();

    }
}
