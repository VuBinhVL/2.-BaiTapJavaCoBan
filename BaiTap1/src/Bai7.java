import java.util.Scanner;
class PhanSo {
    int tuSo, mauSo;
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        if (mauSo == 0) {
            throw new ArithmeticException("Mẫu số không được bằng 0!");
        }
    }

    // Ép kiểu thành số thực để so sánh
    public double giaTriThuc() {
        return (double) tuSo / mauSo;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        PhanSo[] mangPhanSo = new PhanSo[n];

        // Nhập phân số
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phân số thứ " + (i + 1) + ": ");
            System.out.print("Tử số: ");
            int tuSo = sc.nextInt();
            System.out.print("Mẫu số: ");
            int mauSo = sc.nextInt();
            mangPhanSo[i] = new PhanSo(tuSo, mauSo);
        }

        // Tìm min và max
        PhanSo min = mangPhanSo[0];
        PhanSo max = mangPhanSo[0];

        for (int i = 1; i < n; i++) {
            if (mangPhanSo[i].giaTriThuc() < min.giaTriThuc()) {
                min = mangPhanSo[i];
            }
            if (mangPhanSo[i].giaTriThuc() > max.giaTriThuc()) {
                max = mangPhanSo[i];
            }
        }

        // In kết quả
        System.out.println("Phân số nhỏ nhất: " + min);
        System.out.println("Phân số lớn nhất: " + max);
        sc.close();
    }
}
