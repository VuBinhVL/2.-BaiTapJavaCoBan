import java.util.Scanner;

public class Bai_08 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Nhấn enter để bắt đầu");
        sc.nextLine();
        long startTime = System.currentTimeMillis(); //Lưu thời gian bắt đầu làm
        System.out.println("Bắt đầu tính thời gian làm bài. Nhấn enter khi hoành thành!....");
        sc.nextLine();
        long endTime = System.currentTimeMillis(); //Lưu thời gian kết thúc

        //Tính toán thời gian làm bài
        long time = endTime - startTime;
        long hour = time / (1000 * 3600);
        long minute = (time % (1000 * 3600)) / (60 * 1000);
        long second = (time % (60*1000)) / 1000;

        // Hiển thị kết quả
        System.out.println("Thời gian làm bài: " + hour + " giờ, " + minute + " phút, " + second + " giây.");
        sc.close();


    }
}