import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {

    //Hàm nhập
    public static int[] Nhap( Scanner sc)
    {
        System.out.print("Nhập số phần tử trong mảng: ");
        int n = sc.nextInt();
        int [] a = new  int[n];
        System.out.println("Nhập mảng");
        for (int i = 0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }
        return a;
    }

    //Hàm xuất
    public static void Xuat( int [] a)
    {
        System.out.print("Mảng đã nhập là: ");
        for (int i = 0; i<a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    //Hàm thêm vào 1 vị trí bất kỳ
    public static int[] Them( int [] a, Scanner sc)
    {
        int vt,  gt;
        System.out.print("Nhập vị trí muốn thêm : ");
        vt = sc.nextInt();
        while(vt<0 || vt > a.length )
        {
            System.out.println("Vị trí không hợp lệ");
            vt = sc.nextInt();
        }
        System.out.print("Nhập giá trị muốn thêm : ");
        gt = sc.nextInt();

        // Tạo mảng mới với kích thước lớn hơn 1 phần tử
        int[] newArray = new int[a.length + 1];

        // Sao chép phần tử trước vị trí cần chèn
        for (int i = 0; i < vt; i++) {
            newArray[i] = a[i];
        }

        // Chèn phần tử mới
        newArray[vt] = gt;

        // Sao chép phần còn lại
        for (int i = vt; i < a.length; i++) {
            newArray[i + 1] = a[i];
        }


        return newArray;
    }

    // Hàm xóa phần tử tại vị trí bất kỳ
    public static int[] Xoa(int[] a, Scanner sc) {
        System.out.print("Nhập vị trí muốn xóa: ");
        int vt = sc.nextInt();

        // Kiểm tra vị trí hợp lệ
        while (vt < 0 || vt >= a.length) {
            System.out.println("Vị trí không hợp lệ!");
            vt = sc.nextInt();
        }

        // Tạo mảng mới với kích thước nhỏ hơn 1 phần tử
        int[] newArray = new int[a.length - 1];

        // Sao chép các phần tử, trừ phần tử ở vị trí cần xóa
        for (int i = 0, j = 0; i < a.length; i++) {
            if (i != vt) {
                newArray[j++] = a[i];
            }
        }

        System.out.println("Đã xóa phần tử ở vị trí " + vt);
        return newArray;
    }

    // Hàm sửa phần tử trong mảng
    public static void Sua(int[] a, Scanner sc) {
        System.out.print("Nhập vị trí muốn sửa: ");
        int vt = sc.nextInt();

        while (vt < 0 || vt >= a.length) {
            System.out.println("Vị trí không hợp lệ!");
            vt = sc.nextInt();
        }

        System.out.print("Nhập giá trị mới: ");
        a[vt] = sc.nextInt();
        System.out.println("Phần tử đã được cập nhật!");
    }

    // Hàm sắp xếp mảng tăng dần
    public static void SapXep(int[] a) {
        Arrays.sort(a);
    }

    // Hàm tính giá trị trung bình
    public static double TinhTrungBinh(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (double) sum / a.length;
    }

    // Hàm tìm phần tử gần với giá trị trung bình nhất
    public static int TimGanTrungBinh(int[] a, double avg) {
        int gt = a[0];
        double minDiff = Math.abs(a[0] - avg);

        for (int i = 1; i < a.length; i++) {
            double diff = Math.abs(a[i] - avg);
            if (diff < minDiff) {
                minDiff = diff;
                gt = a[i];
            }
        }
        return gt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a;
        a = Nhap(sc);
        Xuat(a);
        //Thêm
        a = Them(a,sc);
        Xuat(a);
        //Xóa
        a = Xoa(a, sc);
        Xuat(a);

        // Gọi hàm sửa phần tử
        Sua(a, sc);
        Xuat(a);

        // Gọi hàm sắp xếp tăng dần
        SapXep(a);
        Xuat(a);

        // Tính giá trị trung bình
        double avg = TinhTrungBinh(a);
        System.out.printf("Giá trị trung bình của mảng: %.2f\n", avg);

        // Tìm phần tử gần với giá trị trung bình nhất
        int closest = TimGanTrungBinh(a, avg);
        System.out.println("Phần tử gần với giá trị trung bình nhất: " + closest);

        sc.close();
    }
}
