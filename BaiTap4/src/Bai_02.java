import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Bai_02 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            while (true)
            {
                LocalTime now = LocalTime.now();
                System.out.println("Thời gian hiện tại: " + now.format(dateTimeFormatter));
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    System.out.println("Lỗi khi lấy thời gian! " + e.getMessage());
                }
            }
        }
        );
        thread.start();
    }
}
