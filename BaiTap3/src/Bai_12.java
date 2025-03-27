import java.io.File;
import java.util.Scanner;

public class Bai_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn tệp từ người dùng
        System.out.print("Nhập đường dẫn tệp cần kiểm tra: ");
        String filePath = scanner.nextLine();

        // Tạo đối tượng File
        File file = new File(filePath);

        // Kiểm tra xem tệp có tồn tại không
        if (file.exists()) {
            System.out.println("Tệp tồn tại.");
            System.out.println("Đường dẫn tuyệt đối: " + file.getAbsolutePath());
            System.out.println("Kích thước (bytes): " + file.length());
            System.out.println("Có thể đọc? " + (file.canRead() ? "Có" : "Không"));
            System.out.println("Có thể ghi? " + (file.canWrite() ? "Có" : "Không"));
            System.out.println("Đây có phải thư mục? " + (file.isDirectory() ? "Có" : "Không"));
        } else {
            System.out.println(" Tệp không tồn tại.");
        }

        scanner.close();
    }
}
