import java.util.Comparator;
import java.util.Scanner;

public class Bai_10 {
    public static <T> T findMax(T[] arr, Comparator<T> comparator) {
        if (arr == null || arr.length == 0) {
            return null; // Trả về null nếu mảng rỗng hoặc null
        }

        T max = arr[0]; // Giả sử phần tử đầu tiên là phần tử lớn nhất
        for (T item : arr) {
            if (comparator.compare(item, max) > 0) { // So sánh item với phần tử max hiện tại
                max = item; // Cập nhật phần tử max nếu item lớn hơn max
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kiểu dữ liệu của mảng (Integer, Double, String)
        System.out.print("Chọn kiểu dữ liệu mảng (1-Integer, 2-Double, 3-String): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) { // Nhập mảng Integer
            System.out.println("Nhập số phần tử trong mảng: ");
            int n = scanner.nextInt();
            Integer[] numbers = new Integer[n];

            System.out.println("Nhập các phần tử mảng số nguyên:");
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            Comparator<Integer> integerComparator = Integer::compareTo; // Comparator cho Integer
            System.out.println("Phần tử lớn nhất trong mảng số nguyên: " + findMax(numbers, integerComparator));

        } else if (choice == 2) { // Nhập mảng Double
            System.out.println("Nhập số phần tử trong mảng: ");
            int n = scanner.nextInt();
            Double[] doubles = new Double[n];

            System.out.println("Nhập các phần tử mảng số thực:");
            for (int i = 0; i < n; i++) {
                doubles[i] = scanner.nextDouble();
            }

            Comparator<Double> doubleComparator = Double::compareTo; // Comparator cho Double
            System.out.println("Phần tử lớn nhất trong mảng số thực: " + findMax(doubles, doubleComparator));

        } else if (choice == 3) { // Nhập mảng String
            System.out.println("Nhập số phần tử trong mảng: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String[] words = new String[n];

            System.out.println("Nhập các phần tử mảng chuỗi:");
            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
            }

            Comparator<String> stringComparator = String::compareTo; // Comparator cho String
            System.out.println("Phần tử lớn nhất trong mảng chuỗi: " + findMax(words, stringComparator));

        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }

        scanner.close();
    }
}
