import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class SinhVien2
{
    private String mssv;
    private String hoTen;
    private String ngaySinh; // format: dd/MM/yyyy
    private String diem;     // format: toan-ly-hoa
    public void nhap(Scanner sc) {
        System.out.print("MSSV: ");
        mssv = sc.nextLine();
        System.out.print("Họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        ngaySinh = sc.nextLine();
        System.out.print("Điểm (Toán-Lý-Hóa): ");
        diem = sc.nextLine();
    }

    @Override
    public String toString() {
        return mssv + " - " + hoTen + " - " + ngaySinh + " - " + diem;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    //Kiểm tra có sinh vào tháng 1 không
    public boolean sinhVaoThang1()
    {
        String [] parts = ngaySinh.trim().split("/");
        return parts.length >= 2 && parts[1].equals("01") ;
    }

    //Lấy điểm toán
    public double getDiemToan()
    {
        StringTokenizer stringTokenizer = new StringTokenizer(diem,"-");
        return Double.parseDouble(stringTokenizer.nextToken()) ;
    }

    //Điểm trung bình
    public double getDiemTB()
    {
        StringTokenizer stringTokenizer = new StringTokenizer(diem,"-");
        double toan = Double.parseDouble(stringTokenizer.nextToken()) ;
        double ly = Double.parseDouble(stringTokenizer.nextToken()) ;
        double hoa = Double.parseDouble(stringTokenizer.nextToken()) ;
        return (toan + ly + hoa) / 3;
    }

    //Số từ trong tên
    public int soTuTrongTen()
    {
        StringTokenizer st = new StringTokenizer(hoTen);
        return  st.countTokens();
    }

}
public class Bai_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien2> danhSach = new ArrayList<>();
        int n;
        while (true) {
            System.out.print("Nhập số lượng sinh viên: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Số lượng sinh viên phải > 0");
                    sc.nextLine();
                } else
                    break;
            } else {
                System.out.println("Phải nhập số");
                sc.nextLine();
            }
        }
        sc.nextLine();

        //Nhập danh sách sinh viên
        System.out.println("=== Nhập danh sách sinh viên ===");
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            SinhVien2 sinhVien = new SinhVien2();
            sinhVien.nhap(sc);
            danhSach.add(sinhVien);
        }

        //In ra danh sách tất cả các sinh viên sinh vào tháng 1.
        System.out.println("=== Danh sách sinh viên sinh vào tháng 1 ===");
        for (SinhVien2 sv : danhSach) {
            if (sv.sinhVaoThang1()) {
                System.out.println(sv);
            }
        }

        //In ra điểm toán của tất cả sinh viên tên “Anh” và tính điểm trung bình 3 môn.
        System.out.println("\n=== b. Điểm toán và ĐTB của sinh viên tên \"Anh\" ===");
        for (SinhVien2 sv : danhSach) {
            StringTokenizer st = new StringTokenizer(sv.getHoTen());
            String firstName = "";
            while (st.hasMoreTokens()) {
                firstName = st.nextToken();
            }
            if (firstName.equalsIgnoreCase("Anh")) {
                System.out.printf("SV: %s | Toán: %.2f | ĐTB: %.2f\n", sv.getHoTen(), sv.getDiemToan(), sv.getDiemTB());
                break;
            }
        }

        System.out.println("\n=== c. Sinh viên có tên nhiều từ nhất ===");
        SinhVien2 svMax = danhSach.get(0);
        for (SinhVien2 sv : danhSach) {
            if (sv.soTuTrongTen() > svMax.soTuTrongTen()) {
                svMax = sv;
            }
        }
        System.out.println("Sinh viên có tên nhiều từ nhất: " + svMax);
    }
}
