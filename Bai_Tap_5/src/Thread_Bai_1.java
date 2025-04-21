//Cách 1
class MyThread extends Thread {
    private String name;

    public MyThread(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(name + ": " + i );
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

//Cách 2
class MyRunable implements Runnable
{
    private String name;

    public MyRunable(String name)
    {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(name + ": " + i);
        }
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
public class Thread_Bai_1 {
    public static void main(String[] args) {
        //C1
//        MyThread thread1 = new MyThread("thread 1");
//        MyThread thread2 = new MyThread("thread 2");
//
//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//
//        thread1.start();
//        thread2.start();

        //C2
        Thread thread3 = new Thread(new MyRunable("Thread 3"));
        Thread thread4 = new Thread(new MyRunable("Thread 4"));

        thread3.setPriority(Thread.MAX_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);

        thread3.start();
        thread4.start();


    }
}
