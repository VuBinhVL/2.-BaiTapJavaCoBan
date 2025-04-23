import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien
{
    private String hoTen;
    private double diemTB;

    //Nhập thông tin sinh viên
    public void Nhap(Scanner sc)
    {
        System.out.print("Nhập họ và tên: ");
        hoTen = sc.nextLine();
        while (true)
        {
            System.out.print("Nhập điểm trung bình: ");
            if (sc.hasNextDouble())
            {
                diemTB = sc.nextDouble();
                sc.nextLine();
                if (diemTB >= 0 && diemTB <= 10)
                {
                    break;
                }
                else {
                    System.out.println("Điểm nhập không hợp lệ! Điểm trung bình phải >= 0 và <= 10");
                }
            }
            else
            {
                System.out.println("Lỗi! Vui lòng nhập số.");
                sc.nextLine();
            }
        }
    }

    //Hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return String.format("Họ tên: %s - Điểm trung bình: %,.1f",hoTen,diemTB);
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getHoTen() {
        return hoTen;
    }
}
public class Bai_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("0. Thoát");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Xem danh sách sinh viên");
            System.out.println("3. Sắp xếp theo điểm trung bình tăng dần");
            System.out.println("4. Tìm sinh viên theo tên");
            System.out.println("5. Xuất sinh viên có họ 'Lê'");
            System.out.print("Chọn chức năng: ");
            String choice = sc.nextLine();
            switch (choice)
            {
                case "0":
                {
                    System.out.println("Thoát chương trình!");
                    return;
                }
                case "1":
                {
                    int n;
                    System.out.print("Nhập số lượng sinh viên: ");
                    try
                    {
                        n = sc.nextInt();
                        if (n < 0)
                        {
                            System.out.println("Số lượng phải lớn hơn 0");
                            sc.nextLine();
                            break;
                        }
                        sc.nextLine();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Số lượng phải là 1 số nguyên");
                        sc.nextLine();
                        break;
                    }
                    for (int i = 0; i < n; i ++)
                    {
                        System.out.printf("Sinh viên %d \n" , i+1);
                        SinhVien sv = new SinhVien();
                        sv.Nhap(sc);
                        sinhViens.add(sv);
                    }
                    break;
                }
                case "2":
                {
                    System.out.println("Danh sách sinh viên");
                    for (SinhVien sv: sinhViens) {
                        System.out.println(sv);
                    }
                    break;
                }
                case "3":
                {
                    sinhViens.sort(Comparator.comparingDouble(sv -> sv.getDiemTB()));
                    System.out.println("\nDanh sách sau khi sắp xếp tăng dần theo điểm trung bình:");
                    for (SinhVien sv: sinhViens) {
                        System.out.println(sv);
                    }
                    break;
                }
                case "4":
                {
                    boolean found = false;
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String timKiem = sc.nextLine().toLowerCase();
                    for (SinhVien sv: sinhViens) {
                        if (sv.getHoTen().toLowerCase().contains(timKiem))
                        {
                            System.out.println("Đã tìm thấy sinh viên - Thông tin sinh viên");
                            found = true;
                            System.out.println(sv);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;
                }
                case "5":
                {
                    boolean found = false;
                    System.out.println("Sinh viên có họ 'Lê':");
                    boolean hasLe = false;
                    for (SinhVien sv: sinhViens) {
                        if (sv.getHoTen().toLowerCase().trim().startsWith("lê"))
                        {
                            System.out.println(sv);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có sinh viên nào họ Lê.");
                    }
                    break;

                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");

            }
        }
    }
}
