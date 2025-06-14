import java.io.*;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tập tin nguồn: ");
        String sourcePath = sc.nextLine();

        System.out.print("Nhập đường dẫn tập tin đích: ");
        String destPath = sc.nextLine();

        try (
                FileInputStream in = new FileInputStream(sourcePath);
                FileOutputStream out = new FileOutputStream(destPath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Đã copy thành công từ '" + sourcePath + "' đến '" + destPath + "'");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
