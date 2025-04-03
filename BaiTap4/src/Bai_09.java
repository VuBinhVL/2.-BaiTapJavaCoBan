import java.util.Scanner;

public class Bai_09 {
    public static <T extends Comparable<T>> int countGreaterThan(T[] arr, T value) {
        int count = 0;
        for (T item : arr) {
            if (item.compareTo(value) > 0) { // So sánh nếu item lớn hơn value
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kiểu dữ liệu của mảng (Integer, Double, String)
        System.out.print("Chọn kiểu dữ liệu mảng (1-Integer, 2-Double, 3-String): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1)
        {
            // Nhập mảng số nguyên
            System.out.print("Nhập số lượng phần tử mảng số nguyên: ");
            int n = scanner.nextInt();
            Integer[] numbers = new Integer[n];
            System.out.println("Nhập các phần tử mảng số nguyên:");
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            // Nhập giá trị cần so sánh
            System.out.print("Nhập giá trị so sánh (số nguyên): ");
            int valueInt = scanner.nextInt();
            System.out.println("Số lượng phần tử lớn hơn " + valueInt + ": " + countGreaterThan(numbers, valueInt));

        }

        if (choice == 2)
        {
            // Nhập mảng số thực
            System.out.print("Nhập số lượng phần tử mảng số thực: ");
            int n = scanner.nextInt();
            Double[] doubles = new Double[n];
            System.out.println("Nhập các phần tử mảng số thực:");
            for (int i = 0; i < n; i++) {
                doubles[i] = scanner.nextDouble();
            }

            // Nhập giá trị cần so sánh
            System.out.print("Nhập giá trị so sánh (số thực): ");
            double valueDouble = scanner.nextDouble();
            System.out.println("Số lượng phần tử lớn hơn " + valueDouble + ": " + countGreaterThan(doubles, valueDouble));

        }

        if (choice == 3)
        {
            // Nhập mảng chuỗi
            scanner.nextLine(); // Đọc hết dòng còn lại sau khi nhập số
            System.out.print("Nhập số lượng phần tử mảng chuỗi: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Đọc hết dòng sau khi nhập số lượng
            String[] words = new String[n];
            System.out.println("Nhập các phần tử mảng chuỗi:");
            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
            }

            // Nhập giá trị cần so sánh
            System.out.print("Nhập giá trị so sánh (chuỗi): ");
            String valueString = scanner.nextLine();
            System.out.println("Số lượng phần tử lớn hơn '" + valueString + "': " + countGreaterThan(words, valueString));

        }

        scanner.close();
    }
}
