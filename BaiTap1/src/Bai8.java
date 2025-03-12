import java.util.Scanner;
import java.util.Arrays;

public class Bai8 {

    // Hàm nhập mảng
    public static int[] nhapMang(int n, Scanner sc) {
        int[] a = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        return a;
    }

    // Hàm xuất mảng
    public static void xuatMang(int[] a) {
        System.out.println("Mảng: " + Arrays.toString(a));
    }

    // Đếm số chẵn và lẻ
    public static void demChanLe(int[] a) {
        int chan = 0, le = 0;
        for (int num : a) {
            if (num % 2 == 0) {
                chan++;
            } else {
                le++;
            }
        }
        System.out.println("Số phần tử chẵn: " + chan);
        System.out.println("Số phần tử lẻ: " + le);
    }

    // Tính giá trị trung bình của mảng
    public static double tinhTrungBinh(int[] a) {
        int tong = 0;
        for (int num : a) {
            tong += num;
        }
        return (double) tong / a.length;
    }

    // Tìm phần tử lớn nhất và nhỏ nhất
    public static void timMinMax(int[] a) {
        int max = a[0], min = a[0];
        for (int num : a) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Phần tử lớn nhất: " + max);
        System.out.println("Phần tử nhỏ nhất: " + min);
    }

    // Xuất mảng theo chiều ngược lại
    public static void xuatMangNguoc(int[] a) {
        System.out.print("Mảng theo chiều ngược lại: [");
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + (i == 0 ? "]\n" : ", "));
        }
    }

    // Sắp xếp mảng tăng dần
    public static void sapXepTangDan(int[] a) {
        Arrays.sort(a);
        System.out.println("Mảng sau khi sắp xếp tăng dần: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        int[] a = nhapMang(n, sc);

        System.out.println("\n=== KẾT QUẢ ===");
        xuatMang(a);
        demChanLe(a);
        System.out.println("Giá trị trung bình của mảng: " + tinhTrungBinh(a));
        timMinMax(a);
        xuatMangNguoc(a);
        sapXepTangDan(a);

        sc.close();
    }
}

