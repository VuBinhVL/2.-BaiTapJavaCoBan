public class Thread_Bai_2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->
        {
            System.out.println("Thread 1: In số chẵn từ 1 đến 100");
            for (int i = 2; i <= 100; i= i + 2)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        Thread thread2 = new Thread(() ->
        {
            System.out.println("Thread 2: In số lẽ từ 1 đến 100");
            for (int i = 1; i <= 99; i= i + 2)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        thread1.start();
        try
        {
            thread1.join();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        thread2.start();

    }
}
