import javax.crypto.spec.PSource;
import java.util.Scanner;

class Person
{
    protected String name;
    protected int age;
    protected String address;

    //Phương thức khởi tạo
    public Person()
    {
        this.name = "Zaier";
        this.age = 21;
        this.address = "Đồng Nai";
    }

    //Phương thức nhập
    public void Input(Scanner scanner)
    {
        System.out.print("Nhập họ và tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
        while (true)
        {
            System.out.print("Nhập tuổi: ");
            if (scanner.hasNextInt())
            {
                age = scanner.nextInt();
                if (age > 0)
                    break;
                else
                    System.out.println("Phải nhập tuổi > 0");
            }
            else
            {
                System.out.println("Lỗi! Phải nhập tuổi là 1 số nguyên ");
            }
            scanner.nextLine();
        }
    }
    //Phương thức hiển thị thông tin
    public void showInformation()
    {
        System.out.println("Họ tên: " + name + " - Tuổi: " + age + " - Địa chỉ: " + address);

    }
    @Override
    public String toString()
    {
        return ("Họ tên: " + name + " - Tuồi: " + age + " - Địa chỉ: " + address);
    }

}

class NhanVien extends Person
{
    private float luongCoBan;
    private float heso;

    //Phương thức khởi tạo
    public NhanVien()
    {
        super();
        this.heso = 2.5F;
        this.luongCoBan = 10000000;
    }

    @Override
    public void Input(Scanner sc)
    {
        super.Input(sc);
        while (true)
        {
            System.out.print("Nhập lương cơ bản: ");
            if (sc.hasNextFloat())
            {
                luongCoBan = sc.nextFloat();
                if (luongCoBan > 0)
                {
                    sc.nextLine();
                    break;
                }
                else
                    System.out.println("Phải nhập lương là 1 số > 0");
            }
            else
            {
                System.out.println("Lỗi! Phải nhập 1 số thực");
            }
            sc.nextLine();
        }

        while (true)
        {
            System.out.print("Nhập hệ số lương: ");
            if (sc.hasNextFloat())
            {
                heso = sc.nextFloat();
                if (heso > 0)
                {
                    sc.nextLine();
                    break;
                }
                else
                    System.out.println("Phải hệ số lương là 1 số > 0");
            }
            else
            {
                System.out.println("Lỗi! Phải nhập 1 số thực");
            }
            sc.nextLine();
        }

    }

    @Override
    public void showInformation()
    {
       super.showInformation();
       System.out.println("Lương: " + payroll() + " - Hệ số lương: " + heso);

    }

    @Override
    public String toString() {
        return String.format("%s - Lương: %,.0f VND - Hệ số lương: %.2f",
                super.toString(), payroll(), heso);
    }


    //Tính lương
    public float payroll()
    {
        return luongCoBan * heso;
    }
}
public class Bai_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double sumPayroll = 0;
        while (true)
        {
            System.out.print("Nhập số lượng nhân viên: ");
            if (sc.hasNextInt())
            {
                n = sc.nextInt();
                if (n > 0)
                {
                    sc.nextLine();
                    break;
                }
                else
                    System.out.println("Lỗi! Phải nhập 1 số nguyên > 0");
            }
            else
            {
                System.out.println("Lỗi! Phải nhập 1 số nguyên");
            }
            sc.nextLine();
        }

        NhanVien[] staffList = new NhanVien[n];
        //Nhập danh sách nhân viên
        for (int i = 0; i < n; i++)
        {
            staffList[i] = new NhanVien();
            staffList[i].Input(sc);
        }

        // Tính tổng lương và xuất thông tin nhân viên có lương cao nhất
        NhanVien maxPayrollStaff = staffList[0];
        for (NhanVien nv: staffList) {
            if (maxPayrollStaff.payroll() < nv.payroll())
            {
                maxPayrollStaff = nv;
            }
            sumPayroll += nv.payroll();
        }
        System.out.printf("Tổng lương: %, .0f VNĐ\n", sumPayroll);
        System.out.println("===== Thông tin nhân viên có lương cao nhất ======");
        System.out.println(maxPayrollStaff);
    }
}
