import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> taskQueue = new LinkedList<>();

        while (true) {
            System.out.println("\n----- HỆ THỐNG QUẢN LÝ TÁC VỤ -----");
            System.out.println("1. Thêm tác vụ");
            System.out.println("2. Xử lý tác vụ");
            System.out.println("3. Hiển thị danh sách tác vụ");
            System.out.println("4. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập tên tác vụ: ");
                    String task = scanner.nextLine();
                    taskQueue.add(task);
                    System.out.println("Đã thêm tác vụ: " + task);
                }
                case 2 -> {
                    if (!taskQueue.isEmpty()) {
                        System.out.println("Xử lý tác vụ: " + taskQueue.poll());
                    } else {
                        System.out.println("Không có tác vụ nào cần xử lý.");
                    }
                }
                case 3 -> {
                    System.out.println("Danh sách tác vụ: " + taskQueue);
                }
                case 4 -> {
                    System.out.println("Thoát chương trình...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
