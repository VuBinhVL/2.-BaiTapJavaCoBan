public class Bai_01 {
    private static boolean daSoi = false;
    private static boolean daChuanBi = false;
    public static void main(String[] args) {
        Thread th1 = new Thread(() ->
        {
            try
            {
                System.out.println("Đang chuẩn bị nguyên liệu ....");
                Thread.sleep(3000);
                daChuanBi = true;
                System.out.println("Đã chuẩn bị xong nguyên liệu!");
            }
            catch (Exception e)
            {
                System.out.println("Lỗi khi chuẩn bị nguyên liệu " + e.getMessage());
            }
        });

        Thread th2 = new Thread(() ->
        {
            try
            {
                System.out.println("Đang chuẩn bị đun nước...");
                Thread.sleep(5000);
                daSoi = true;
                System.out.println("Đã đun nước xong!");

            }
            catch (Exception e)
            {
                System.out.println("Lỗi khi dung nước " + e.getMessage());
            }
        });

        Thread th3 = new Thread(() ->
        {
            try
            {
                th1.join();
                th2.join();
                if(daSoi && daChuanBi)
                {
                    System.out.println("Đang nấu mì ....");
                    Thread.sleep(5000);
                    System.out.println("Đã nấu mì xong!");
                }
            }
            catch (Exception e)
            {
                System.out.println("Lỗi khi nấu mì" + e.getMessage());
            }
        });
       th1.start();
       th2.start();
       th3.start();

    }
}
