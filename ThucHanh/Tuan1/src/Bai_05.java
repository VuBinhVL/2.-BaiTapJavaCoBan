import java.util.ArrayList;
import java.util.Scanner;

interface Measurable
{
    double Valuate();
}
class Staff implements Measurable
{
    private String hoTen;
    private String maNV;
    private double soGioLam;
    private double giaTheoGio;
    public void Nhap(Scanner sc) {
        sc.nextLine();
        System.out.print("Nhập họ tên nhân viên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.print("Nhập số giờ làm: ");
        soGioLam = sc.nextDouble();
        System.out.print("Nhập giá theo giờ: ");
        giaTheoGio = sc.nextDouble();
    }
    @Override
    public double Valuate() {
        return soGioLam * giaTheoGio;
    }

    @Override
    public String toString() {
        return String.format("Nhân viên: %s  - Mã: %s  - Lương: %,.0f VNĐ",hoTen,maNV,Valuate());
    }
}

class Student implements Measurable
{
    private String hoTen;
    private String maSV;
    private double toan, ly, hoa;
    public void Nhap(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Nhập họ tên sinh viên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        maSV = sc.nextLine();
        System.out.print("Nhập điểm Toán: ");
        toan = sc.nextDouble();
        System.out.print("Nhập điểm Lý: ");
        ly = sc.nextDouble();
        System.out.print("Nhập điểm Hóa: ");
        hoa = sc.nextDouble();
    }
    @Override
    public double Valuate() {
        return (toan + ly + hoa) / 3;
    }
    @Override
    public String toString() {
        return String.format("Sinh viên: %s  - Mã: %s  - Điểm trung bình: %.2f",hoTen,maSV,Valuate());
    }
}

public class Bai_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        ArrayList<Measurable> list = new ArrayList<>();


        //Nhập danh sách nhân viên
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
        for (int i = 0; i < n; i++)
        {
            System.out.println("Nhân viên " + (i+1));
            Staff nv = new Staff();
            nv.Nhap(sc);
            list.add(nv);
        }


        //Nhập danh sách sinh viên
        while (true)
        {
            System.out.print("Nhập số lượng sinh viên: ");
            if (sc.hasNextInt())
            {
                m = sc.nextInt();
                if (m < 0)
                {
                    System.out.println("Số lượng sinh viên phải > 0");
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
        for (int i = 0; i < m; i++)
        {
            System.out.println("Sinh viên " + (i+1));
            Student student = new Student();
            student.Nhap(sc);
            list.add(student);
        }

        // Xuất danh sách
        System.out.println("\n--- DANH SÁCH ---");
        for (Measurable ms: list) {
            if (ms instanceof Staff)
                System.out.println(ms);
            else if (ms instanceof Student) {
                System.out.println(ms);
            }
        }

        // Tính trung bình
        System.out.println("\n--- TÍNH TRUNG BÌNH ---");
        double tongLuong = 0, tongDiem = 0;
        int countNV = 0, countSV = 0;
        for (Measurable ms: list) {
            if (ms instanceof Staff)
            {
                tongLuong += ms.Valuate();
                countNV++;
            }
            else if (ms instanceof Student) {
                tongDiem += ms.Valuate();
                countSV++;
            }
        }
        System.out.printf("Lương trung bình của nhân viên: %,.2f VNĐ \n", (tongLuong / countNV) );
        System.out.printf("Điểm trung bình của nhân viên: %.2f \n ", (tongDiem / countNV) );
    }
}
