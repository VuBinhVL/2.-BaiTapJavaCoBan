import java.util.Scanner;
import java.util.Arrays;

public class Bai_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập mảng số nguyên từ người dùng
        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();

        // Kiểm tra nếu mảng có ít hơn 5 phần tử, chương trình kết thúc ngay lập tức
        if (size < 5) {
            System.out.println("Mảng phải có ít nhất 5 phần tử. Kết thúc chương trình!");
            System.exit(0);
        }

        int[] originalArray = new int[size];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            originalArray[i] = scanner.nextInt();
        }

        // Sao chép mảng bằng System.arraycopy()
        int[] copiedArray = new int[size];
        System.arraycopy(originalArray, 0, copiedArray, 0, size);

        // Nhập tên người dùng và lưu vào thuộc tính hệ thống
        System.out.print("Nhập tên người sử dụng: ");
        scanner.nextLine(); // Xóa bộ đệm
        String userName = scanner.nextLine();
        System.setProperty("user.name", userName);

        // Lấy thông tin tên người dùng từ thuộc tính hệ thống
        String retrievedUserName = System.getProperty("user.name");

        // Hiển thị kết quả
        System.out.println("\nMảng gốc: " + Arrays.toString(originalArray));
        System.out.println("Mảng sao chép: " + Arrays.toString(copiedArray));
        System.out.println("Tên người sử dụng: " + retrievedUserName);

        scanner.close();
    }
}
