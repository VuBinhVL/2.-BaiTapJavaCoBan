import java.util.Random;
import java.util.Scanner;

public class Bai_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Nhập số bước đi từ người dùng
        System.out.print("Nhập số bước đi: ");
        int soBuoc = scanner.nextInt();

        // Khởi tạo tọa độ ban đầu (0,0)
        int x = 0, y = 0;

        // Mô phỏng quá trình đi bộ ngẫu nhiên
        for (int i = 0; i < soBuoc; i++) {
            int huong = random.nextInt(4); // Sinh số ngẫu nhiên từ 0 đến 3

            switch (huong) {
                case 0 -> y++;  // Đi lên
                case 1 -> y--;  // Đi xuống
                case 2 -> x--;  // Đi trái
                case 3 -> x++;  // Đi phải
            }
        }

        // Tính khoảng cách Euclid từ điểm gốc (0,0)
        double khoangCach = Math.sqrt(x * x + y * y);

        // Hiển thị kết quả
        System.out.println("Vị trí cuối cùng: (" + x + ", " + y + ")");
        System.out.printf("Khoảng cách Euclid: %.2f\n", khoangCach);

        scanner.close();
    }
}
