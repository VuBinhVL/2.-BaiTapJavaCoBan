import java.util.Scanner;

class SoPhuc
{
    private double thuc;
    private double ao;

    //Khởi tạo
    public SoPhuc()
    {
        thuc = 1;
        ao = 1;
    }
    public SoPhuc(double a, double b)
    {
        thuc = a;
        ao = b;
    }

    //Phép cộng
    public SoPhuc Cong(SoPhuc a)
    {
        SoPhuc kq = new SoPhuc();
        kq.thuc = thuc + a.thuc;
        kq.ao = ao + a.ao;
        return  kq;
    }

    //Phép trừ
    public SoPhuc Tru(SoPhuc a)
    {
        SoPhuc kq = new SoPhuc();
        kq.thuc = thuc - a.thuc;
        kq.ao = ao - a.ao;
        return  kq;
    }

    //Phép nhân
    public SoPhuc Nhan(SoPhuc a)
    {
        SoPhuc kq = new SoPhuc();
        kq.thuc = thuc * a.thuc - ao * a.ao;
        kq.ao = thuc * a.ao + ao * a.thuc;
        return  kq;
    }

    //Phép chia
    public SoPhuc Chia(SoPhuc a)
    {
        SoPhuc kq = new SoPhuc();
        double sochia = Math.pow(a.thuc,2) + Math.pow(a.ao,2);
        kq.thuc = (thuc * a.thuc + ao * a.ao) / sochia;
        kq.ao = (ao * a.thuc - thuc * a.ao) / sochia;
        return  kq;
    }
    //Hiển thị

    @Override
    public String toString() {
        if (ao > 0)
            return String.format("%,.2f + %,.2f*i", thuc, ao);
        else
            return String.format("%,.2f - %,.2f*i", thuc, -ao);

    }
}
public class Bai_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phức thứ nhất
        System.out.println("Nhập số phức thứ nhất:");
        System.out.print("Phần thực: ");
        double r1 = sc.nextDouble();
        System.out.print("Phần ảo: ");
        double i1 = sc.nextDouble();
        SoPhuc c1 = new SoPhuc(r1, i1);

        // Nhập số phức thứ hai
        System.out.println("Nhập số phức thứ hai:");
        System.out.print("Phần thực: ");
        double r2 = sc.nextDouble();
        System.out.print("Phần ảo: ");
        double i2 = sc.nextDouble();
        SoPhuc c2 = new SoPhuc(r2, i2);

        // Hiển thị kết quả các phép toán
        System.out.println("Số phức 1: " + c1);
        System.out.println("Số phức 2: " + c2);
        System.out.println("Cộng: " + c1.Cong(c2));
        System.out.println("Trừ: " + c1.Tru(c2));
        System.out.println("Nhân: " + c1.Nhan(c2));
        System.out.println("Chia: " + c1.Chia(c2));
    }
}
