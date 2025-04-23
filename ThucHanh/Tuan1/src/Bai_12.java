import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

abstract class Tour
{
    protected String maTour, tenTour, ngayBatDau, ngayKetThuc;
    protected int soLuongToiDa, soLuongThucTe;
    protected double giaTour;
    public Tour(String maTour, String tenTour, int soLuongToiDa, int soLuongThucTe,
                double giaTour, String ngayBatDau, String ngayKetThuc) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.soLuongToiDa = soLuongToiDa;
        this.soLuongThucTe = soLuongThucTe;
        this.giaTour = giaTour;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    public String getMaTour() {
        return maTour;
    }

    public abstract double tinhDoanhThu();

    public abstract String getLoaiTour();


    @Override
    public String toString() {
        return String.format("[%s] %s | %s -> %s | %d/%d | %.2f VND | Loại tour: %s", maTour, tenTour, ngayBatDau, ngayKetThuc,
                soLuongThucTe, soLuongToiDa, giaTour, getLoaiTour());
    }
}

class TourTrongNuoc extends Tour{
    private String tinhThanh;
    public TourTrongNuoc(String maTour, String tenTour, int soLuongToiDa, int soLuongThucTe,
                         double giaTour, String ngayBatDau, String ngayKetThuc, String tinhThanh) {
        super(maTour, tenTour, soLuongToiDa, soLuongThucTe, giaTour, ngayBatDau, ngayKetThuc);
        this.tinhThanh = tinhThanh;
    }
    @Override
    public double tinhDoanhThu() {
        return soLuongThucTe * giaTour - (soLuongToiDa - soLuongThucTe) * 0.03 * giaTour;

    }
    @Override
    public String getLoaiTour() {
        return "Trong Nuoc";
    }
    @Override
    public String toString() {
        return super.toString() + " | Tỉnh: " + tinhThanh + " | Doanh thu: " + String.format("%.2f", tinhDoanhThu());
    }
}

class TourQuocTe extends Tour
{
    private String quocGia;

    public TourQuocTe(String maTour, String tenTour, int soLuongToiDa, int soLuongThucTe,
                      double giaTour, String ngayBatDau, String ngayKetThuc, String quocGia) {
        super(maTour, tenTour, soLuongToiDa, soLuongThucTe, giaTour, ngayBatDau, ngayKetThuc);
        this.quocGia = quocGia;
    }
    @Override
    public double tinhDoanhThu() {
        return soLuongThucTe * giaTour - (soLuongToiDa - soLuongThucTe) * 0.10 * giaTour;
    }
    @Override
    public String getLoaiTour() {
        return "Quoc Te";
    }
    @Override
    public String toString() {
        return super.toString() + " | Quốc gia: " + quocGia + " | Doanh thu: " + String.format("%.2f", tinhDoanhThu());
    }
}
public class Bai_12 {
    private static ArrayList<Tour> danhSachTour = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String choice;
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Nhập danh sách tour");
            System.out.println("2. Thêm một tour");
            System.out.println("3. Tính tổng doanh thu & đếm số lượng từng loại");
            System.out.println("4. Tính tổng doanh thu tất cả tour");
            System.out.println("5. Kiểm tra tour theo mã");
            System.out.println("6. Xóa tour theo mã");
            System.out.println("7. Sắp xếp theo loại tour");
            System.out.println("8. Sắp xếp theo loại tour và doanh thu giảm dần");
            System.out.println("9. Xuất danh sách tour");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextLine();
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> nhapDanhSachTour();
                case "2" -> themTour();
                case "3" -> thongKeLoaiTour();
                case "4"-> tongDoanhThu();
                case "5" -> kiemTraTour();
                case "6" -> xoaTour();
                case "7" -> sapXepTheoLoai();
                case "8" -> sapXepTheoLoaiVaDoanhThu();
                case "9" -> xuatDanhSach();
            }
        }
    }

    public static void nhapDanhSachTour()
    {
        System.out.print("Nhập số lượng tour: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            themTour();
        }
    }
    public static void themTour() {
        System.out.print("Loại tour (1. Trong nước | 2. Quốc tế): ");
        String loai = sc.nextLine();
        System.out.print("Mã tour: ");
        String ma = sc.nextLine();
        System.out.print("Tên tour: ");
        String ten = sc.nextLine();
        System.out.print("Số lượng tối đa: ");
        int max = Integer.parseInt(sc.nextLine());
        System.out.print("Số lượng thực tế: ");
        int thucTe = Integer.parseInt(sc.nextLine());
        System.out.print("Giá tour: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Ngày bắt đầu: ");
        String batDau = sc.nextLine();
        System.out.print("Ngày kết thúc: ");
        String ketThuc = sc.nextLine();

        if (loai.equals("1")) {
            System.out.print("Tỉnh/thành đi qua: ");
            String tinh = sc.nextLine();
            danhSachTour.add(new TourTrongNuoc(ma, ten, max, thucTe, gia, batDau, ketThuc, tinh));
        } else {
            System.out.print("Quốc gia đi qua: ");
            String qg = sc.nextLine();
            danhSachTour.add(new TourQuocTe(ma, ten, max, thucTe, gia, batDau, ketThuc, qg));
        }
    }

    public static void thongKeLoaiTour() {
        int countTN = 0, countQT = 0;
        double dtTN = 0, dtQT = 0;
        for (Tour t : danhSachTour) {
            if (t instanceof TourTrongNuoc) {
                countTN++;
                dtTN += t.tinhDoanhThu();
            } else {
                countQT++;
                dtQT += t.tinhDoanhThu();
            }
        }
        System.out.printf("Trong nước: %d tour - Doanh thu: %,.2f VNĐ\n", countTN, dtTN);
        System.out.printf("Quốc tế: %d tour - Doanh thu: %,.2f VNĐ\n", countQT, dtQT);
    }

    public static void tongDoanhThu() {
        double tong = 0;
        for (Tour t : danhSachTour) {
            tong += t.tinhDoanhThu();
        }
        System.out.printf("Tổng doanh thu: %,.2f VNĐ\n", tong);
    }

    public static void kiemTraTour() {
        System.out.print("Nhập mã tour cần kiểm tra: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (Tour t : danhSachTour) {
            if (t.getMaTour().equalsIgnoreCase(ma)) {
                System.out.println("Tìm thấy tour: " + t);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Không tìm thấy tour.");
    }

    public static void xoaTour() {
        System.out.print("Nhập mã tour cần xóa: ");
        String ma = sc.nextLine();
        danhSachTour.removeIf(t -> t.getMaTour().equalsIgnoreCase(ma));
    }

    public static void sapXepTheoLoai() {
        danhSachTour.sort(Comparator.comparing(t ->t.getLoaiTour()));
    }

    public static void sapXepTheoLoaiVaDoanhThu() {
        danhSachTour.sort(Comparator.comparing(Tour::getLoaiTour)
                .thenComparing((t1, t2) -> Double.compare(t2.tinhDoanhThu(), t1.tinhDoanhThu())));
    }

    public static void xuatDanhSach() {
        for (Tour t : danhSachTour) {
            System.out.println(t);
        }
    }
}
