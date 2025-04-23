import java.util.ArrayList;
import java.util.Scanner;

abstract class NhanSu
{
    protected String hoTen;
    protected String ngaySinh;
    protected double heSoLuong;

    public abstract double tinhLuong();
    public abstract void Nhap(Scanner scanner);
    @Override
    public String toString() {
        return String.format("Họ tên: %s  - Ngày sinh: %s - Lương: %,.0f", hoTen, ngaySinh, tinhLuong());
    }
    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
}
 class GiamDoc extends NhanSu
 {
     protected double heSoChucVu;
     @Override
     public double tinhLuong() {
         return (heSoLuong + heSoChucVu) * 1200000;
     }

     @Override
     public void Nhap(Scanner scanner) {
         System.out.print("Nhập họ tên giám đốc: ");
         hoTen = scanner.nextLine();
         System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
         ngaySinh = scanner.nextLine();
         System.out.print("Nhập hệ số lương: ");
         heSoLuong = scanner.nextDouble();
         System.out.print("Nhập hệ số chức vụ: ");
         heSoChucVu = scanner.nextDouble();
         scanner.nextLine();
     }
 }
class QuanLy extends NhanSu
{    private int soNhanVienQuanLy;

    @Override
    public double tinhLuong() {
        return heSoLuong * 1200000;
    }

    @Override
    public void Nhap(Scanner scanner) {
        System.out.print("Nhập họ tên quản lý: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        ngaySinh = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        heSoLuong = scanner.nextDouble();
        System.out.print("Nhập số lượng nhân viên quản lý: ");
        soNhanVienQuanLy = scanner.nextInt();
        scanner.nextLine(); // clear buffer
    }

}
 class NhanVienThuong extends NhanSu
 {
     private String tenDonVi;
     @Override
     public double tinhLuong() {
         return heSoLuong * 1200000;
     }

     @Override
     public void Nhap(Scanner scanner) {
         System.out.print("Nhập họ tên nhân viên: ");
         hoTen = scanner.nextLine();
         System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
         ngaySinh = scanner.nextLine();
         System.out.print("Nhập hệ số lương: ");
         heSoLuong = scanner.nextDouble();
         scanner.nextLine();
         System.out.print("Nhập đơn vị (phòng/ban): ");
         tenDonVi = scanner.nextLine();
     }

     @Override
     public String toString() {
         return super.toString() + "  - Phòng ban: " + tenDonVi;
     }

     public String getTenDonVi() {
         return tenDonVi;
     }
 }
public class Bai_07 {
    public static void main(String[] args) {
        ArrayList<NhanSu> listNhanSu = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n ;
        while (true)
        {
            System.out.print("Nhập số lượng nhân viên: ");
            if (sc.hasNextInt())
            {
                n = sc.nextInt();
                if (n < 0)
                {
                    System.out.println("Số lượng nhân viên phải > 0");
                    sc.nextLine();
                }
                else
                    break;
            }
            else
            {
                System.out.println("Phải nhập số");
                sc.nextLine();
            }
        }
        sc.nextLine();

        //Nhập danh sách nhân viên
        for (int i = 0; i < n; i++)
        {
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1));
            System.out.print("Chọn loại (1: Giám đốc, 2: Quản lý, 3: Nhân viên): ");
            String choice = sc.nextLine();
            NhanSu ns = null;
            if (choice.equals("1"))
            {
                 ns = new GiamDoc();
            }
            else if (choice.equals("2"))
            {
                ns = new QuanLy();
            }
            else if (choice.equals("3"))
                ns = new NhanVienThuong();
            else
                System.out.println("Lựa chọn không hợp lệ");
            ns.Nhap(sc);
            listNhanSu.add(ns);
        }
        //Hiển thị danh sách nhân viên
        System.out.println("\n=== Danh sách nhân viên ===");
        for (NhanSu ns : listNhanSu) {
            System.out.println(ns);
        }

        //Hiển thị nhân viên có lương cao nhất
        double maxLuong = 0;
        NhanSu maxLuongns = null;
        for (NhanSu ns : listNhanSu) {
            if (ns.tinhLuong() > maxLuong) {
                maxLuong = ns.tinhLuong();
                maxLuongns = ns;
            }
        }
        System.out.println("\n=== Nhân viên có lương cao nhất ===");
        System.out.println(maxLuongns);

        //Hiển thị nhân viên sinh trong tháng 2
        System.out.println("\n=== Nhân viên sinh tháng 2 ===");
        for (NhanSu ns : listNhanSu) {
            if (ns.getNgaySinh().contains("/02/")) {
                System.out.println(ns);
            }
        }

        // Thuộc phòng kế toán
        System.out.println("\n=== Nhân viên thuộc phòng Kế toán ===");
        for (NhanSu ns: listNhanSu) {
            if (ns instanceof NhanVienThuong)
            {
                if(((NhanVienThuong) ns).getTenDonVi().equalsIgnoreCase("Kế toán"))
                    System.out.println(ns);
            }
        }

        //Đếm tên An
        int dem = 0;
        for (NhanSu ns: listNhanSu) {
          String [] parts = ns.getHoTen().trim().split(" ");
          String ten = parts[parts.length - 1];
          if (ten.equalsIgnoreCase("An"))
              dem ++;
        }
        System.out.println("\nSố lượng nhân viên tên là \"An\": " + dem);


    }
}
