import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try
        {
            //Nhập thời gian
            System.out.print("Nhập mốc thời gian thứ nhất (HH:mm:ss): ");
            LocalTime t1 = LocalTime.parse(sc.nextLine(),dateTimeFormatter);

            System.out.print("Nhập mốc thời gian thứ hai (HH:mm:ss): ");
            LocalTime t2 = LocalTime.parse(sc.nextLine(),dateTimeFormatter);

            //Tính khoảng cách thời gian
            Duration duration = Duration.between(t1,t2);
            long tongGiay = duration.getSeconds();

            //Chuyển đổi khoảng cách thời gian thành h,m,s
            long gio = tongGiay / 3600;
            long phut = (tongGiay % 3600) / 60;
            long giay = tongGiay % 60;

            System.out.println("Khoảng cách thời gian: " + gio + " giờ " + phut + " phút " + giay + " giây");
        }
        catch (Exception e)
        {
            System.out.println("Lỗi:" + e.getMessage());
        }
    }
}
