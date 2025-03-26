import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SinhVien
{
    String hoTen, mSSV;
    List<LopHoc> lopDaDangKy = new ArrayList<LopHoc>();
    public SinhVien(String hoTen, String mSSV)
    {
        this.hoTen = hoTen;
        this.mSSV = mSSV;
    }
    public void Nhap (Scanner sc)
    {

        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập mã số sinh viên: ");
        mSSV = sc.nextLine();
    }

    public void Xuat()
    {
        System.out.println("Họ tên: " + hoTen + " - MSSV: " + mSSV);
    }

    public int soTinChiDaDangKy()
    {
        return lopDaDangKy.stream().mapToInt(lop -> lop.soTinChi).sum();
    }

    public void dangKyMonHoc(LopHoc lopHoc)
    {
        lopDaDangKy.add(lopHoc);
    }
}

class LopHoc
{
    String maLop, tenMon;
    int soTinChi, tietBatDau, tietKetThuc, thu;
    String  ngayBatDau, ngayKetThuc;

    List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
    public LopHoc(String maLop, String tenMon, int soTinChi, int tietBatDau, int tietKetThuc
    , int thu, String ngayBatDau, String ngayKetThuc)
    {
        this.maLop = maLop;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.tietBatDau = tietBatDau;
        this.tietKetThuc = tietKetThuc;
        this.thu = thu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;

    }

    public String getTenMon() {
        return tenMon;
    }

    public void Nhap(Scanner sc) {
        System.out.print("Nhập mã lớp: ");
        maLop = sc.nextLine();
        System.out.print("Nhập tên môn: ");
        tenMon = sc.nextLine();
        System.out.print("Nhập số tín chỉ: ");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Lỗi. Nhập lại số tín chỉ môn học: ");
                sc.next();
            }
            soTinChi = sc.nextInt();
            if (soTinChi >= 1)
            {
                break;
            }
            System.out.println("Số tín chỉ phải  >= 1. Nhập lại số tín chỉ: ");
        }

        System.out.print("Nhập tiết bắt đầu môn học: ");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Lỗi. Nhập lại tiết bắt đầu môn học: ");
                sc.next();
            }
            tietBatDau = sc.nextInt();
            if (tietBatDau >= 1)
            {
                break;
            }
            System.out.println("Tiết bắt đầu  phải >= 1. Nhập lại tiết bắt đầu: ");
        }

        System.out.print("Nhập tiết kết thúc môn học: ");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Lỗi. Nhập lại tiết kết thúc môn học: ");
                sc.next();
            }
            tietKetThuc = sc.nextInt();
            if (tietKetThuc >= 1)
            {
                break;
            }
            System.out.println("Tiết kết thúc  phải >= 1. Nhập lại tiết kết thúc: ");
        }
        sc.nextLine();
        System.out.print("Nhập thứ học môn này: ");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Lỗi. Nhập lại thứ học môn này: ");
                sc.next();
            }
            thu = sc.nextInt();
            if (thu >= 2 || thu <= 7)
            {
                break;
            }
            System.out.println("Thứ học môn này phải từ thứ 2 đến thứ 7. Nhập lại tiết kết thúc: ");
        }
        System.out.print("Nhập ngày bắt đầu học môn này (dd/mm/yyyy): ");
        ngayBatDau = sc.nextLine();
        System.out.print("Nhập ngày kết thúc môn này (dd/mm/yyyy): ");
        ngayKetThuc = sc.nextLine();
    }

    public int soLuongSinhVienDangKy()
    {
        return sinhVienList.size();
    }
}
public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        List<LopHoc> lopHocList = new ArrayList<LopHoc>();
        nhapDanhSachSinhVien(sc,sinhVienList);
        nhapDanhSachLopHoc(sc,lopHocList);
        //Đăng ký học phần
        for (SinhVien sv: sinhVienList ){
            dangKyHocPhan(sv,lopHocList,sc);
        }
        //Thống kê
        thongKe(sinhVienList, lopHocList);
        //Xem thời khóa của 1 sinh viên
        xemThoiKhoaBieu(sc,sinhVienList);

    }
    public static void nhapDanhSachSinhVien (Scanner sc, List<SinhVien> sv) {
        int n;
        System.out.print("Nhập số lượng sinh viên: ");
        while (!sc.hasNextInt()) {
            System.out.print("Lỗi. Hãy nhập lại số lượng sinh viên: ");
            sc.next();
        }
        n = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập danh sách sinh viên");
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            System.out.print("Nhập họ tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Nhập mã số sinh viên: ");
            String mSSV = sc.nextLine();
            sv.add(new SinhVien(hoTen, mSSV));
        }
    }

    public static void nhapDanhSachLopHoc (Scanner sc, List<LopHoc> lopHocList)
    {
        int n, soTinChi, tietBatDau, tietKetThuc, thu;
        System.out.print("Nhập số lượng lớp học: ");
        while (!sc.hasNextInt()) {
            System.out.print("Lỗi. Hãy nhập lại số lượng lớp học: ");
            sc.next();
        }
        n = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập danh sách lớp học");
        for (int i = 0; i < n; i++) {
            System.out.println("Lớp thứ " + (i + 1));
            System.out.print("Nhập mã lớp: ");
            String maLop = sc.nextLine();
            System.out.print("Nhập tên môn: ");
            String tenMon = sc.nextLine();
            System.out.print("Nhập số tín chỉ: ");
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Lỗi. Nhập lại số tín chỉ môn học: ");
                    sc.next();
                }
                soTinChi = sc.nextInt();
                if (soTinChi >= 1)
                {
                    break;
                }
                System.out.println("Số tín chỉ phải  >= 1. Nhập lại số tín chỉ: ");
            }

            System.out.print("Nhập tiết bắt đầu môn học: ");
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Lỗi. Nhập lại tiết bắt đầu môn học: ");
                    sc.next();
                }
                tietBatDau = sc.nextInt();
                if (tietBatDau >= 1)
                {
                    break;
                }
                System.out.println("Tiết bắt đầu  phải >= 1. Nhập lại tiết bắt đầu: ");
            }

            System.out.print("Nhập tiết kết thúc môn học: ");
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Lỗi. Nhập lại tiết kết thúc môn học: ");
                    sc.next();
                }
                tietKetThuc = sc.nextInt();
                if (tietKetThuc >= 1)
                {
                    break;
                }
                System.out.println("Tiết kết thúc  phải >= 1. Nhập lại tiết kết thúc: ");
            }
            sc.nextLine();
            System.out.print("Nhập thứ học môn này: ");
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Lỗi. Nhập lại thứ học môn này: ");
                    sc.next();
                }
                thu = sc.nextInt();
                if (thu >= 2 || thu <= 7)
                {
                    break;
                }
                System.out.println("Thứ học môn này phải từ thứ 2 đến thứ 7. Nhập lại tiết kết thúc: ");
            }
            sc.nextLine();
            System.out.print("Nhập ngày bắt đầu học môn này (dd/mm/yyyy): ");
            String ngayBatDau = sc.nextLine();
            System.out.print("Nhập ngày kết thúc môn này (dd/mm/yyyy): ");
            String ngayKetThuc = sc.nextLine();
            lopHocList.add( new LopHoc(maLop,tenMon, soTinChi, tietBatDau, tietKetThuc, thu, ngayBatDau, ngayKetThuc));
        }
    }

    public static void dangKyHocPhan(SinhVien sinhVien, List<LopHoc> lopHocList, Scanner sc)
    {
        System.out.println("===== Bắt đầu đăng ký môn học ======");
        sinhVien.Xuat();
        while (true)
        {
            System.out.print("Nhập mã lớp muốn đăng ký (hoặc '1' để kết thúc): ");
            String maLopDK = sc.nextLine();
            if (maLopDK.equals("1"))
            {
                break;
            }
            LopHoc lh = lopHocList.stream()
                    .filter(lop -> lop.maLop.equals(maLopDK))
                    .findFirst()
                    .orElse(null);
            if (lh == null)
            {
                System.out.println("Không tìm thấy lớp với mã " + maLopDK);
            }
            else if( sinhVien.soTinChiDaDangKy() + lh.soTinChi > 24)
            {
                System.out.println("Đăng ký thất bại: Tổng số tín chỉ vượt quá giới hạn (24 tín chỉ)");
                break;
            }
            else if (sinhVien.lopDaDangKy.contains(lh))
            {
                System.out.println("Sinh viên đã đăng ký lớp này rồi!");
            }
            else
            {
                sinhVien.dangKyMonHoc(lh);
                lh.sinhVienList.add(sinhVien);
                System.out.println("Đăng ký thành công môn: " + lh.tenMon);
            }
        }


    }

    public static void thongKe(List<SinhVien> sinhVienList, List<LopHoc> lopHocList)
    {
        SinhVien sinhVienNhieuMonNhat = sinhVienList.stream().max(Comparator.comparingInt(l -> l.lopDaDangKy.size())).orElse(null);
        SinhVien sinhVienNhieuTinChiNhat = sinhVienList.stream().max(Comparator.comparingInt(SinhVien::soTinChiDaDangKy)).orElse(null);
        LopHoc lopHocMaxSinhVIen = lopHocList.stream().max(Comparator.comparingInt(sv -> sv.soLuongSinhVienDangKy())).orElse(null);

        System.out.print("Sinh viên đăng ký nhiều môn nhất là: ");
        sinhVienNhieuMonNhat.Xuat();
        System.out.print("Sinh viên đăng ký nhiều tín chỉ nhất là nhất là: ");
        sinhVienNhieuTinChiNhat.Xuat();
        System.out.println("Môn học có nhiều sinh viên đăng ký nhất là: " + lopHocMaxSinhVIen.getTenMon());
    }

    public static void xemThoiKhoaBieu( Scanner sc, List<SinhVien> sinhVienList)
    {
        String mssv;
        System.out.print("Nhập mã số sinh viên cần xem thời khóa biểu: ");
        mssv = sc.nextLine();
        SinhVien sinhVienCanTim = sinhVienList.stream().filter(sinhVien -> sinhVien.mSSV.equals(mssv)).findFirst().orElse(null);
        if (sinhVienCanTim == null)
        {
            System.out.println("Không tìm thấy sinh viên có MSSV này.");
        }
        else
        {
            sinhVienCanTim.lopDaDangKy.stream().sorted(Comparator.comparingInt(lh -> lh.thu))
                    .forEach(lop -> {
                        System.out.println("Thứ " + lop.thu + " - " + lop.tenMon + ": Tiết " + lop.tietBatDau + " đến " + lop.tietKetThuc);
                    });
        }
    }
}
