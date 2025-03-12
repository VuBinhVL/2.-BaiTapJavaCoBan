import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SoSanhDuoc<T>
{
    public abstract int soSanh(T a, T b);
}

interface SapXepDuoc<T>
{
    public abstract void SapXepGiamDan();
    public abstract void SapXepTangDan();
    public abstract T Max();
    public abstract T Min();
}

class PhanSo2 implements SoSanhDuoc<PhanSo2>
{
    int tu, mau;
    public PhanSo2()
    {
        tu = 1;
        mau = 1;
    }
    public PhanSo2 (int t, int m)
    {
        if (m == 0)
        {
            return;
        }
        this.tu = t;
        this.mau = m;
    }
    public void Nhap(Scanner sc)
    {

        System.out.print("Nhập tử số: ");
        while(!sc.hasNextInt())
        {
            System.out.println("Lỗi vui lòng nhập lại tử số");
            sc.next();
            System.out.print("Nhập tử số: ");
        }
        this.tu = sc.nextInt();

        System.out.print("Nhập mẫu số: ");
        while (true)
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Lỗi vui lòng nhập lại mẫu số");
                sc.next();
                System.out.print("Nhập mẫu số: ");
            }
            this.mau = sc.nextInt();
            if (this.mau != 0)
            {
                break;
            }
            System.out.println("Lỗi mẫu số phải khác 0!");
            System.out.print("Nhập mẫu số: ");
        }
    }

    public  void Xuat()
    {
        System.out.println(tu + "/" + mau);
    }

    @Override
    public int soSanh(PhanSo2 a, PhanSo2 b) {
        double ps1 = (double) a.tu / a.mau;
        double ps2 = (double) b.tu / b.mau;
        if ( ps1 > ps2)
            return 1;
        else if (ps1 == ps2)
            return 0;
        return -1;
       //return Double.compare(ps1,ps2);
    }
    @Override
    public String toString()
    {
        return tu + "/" + mau;
    }
}
class MangPhanSo implements SapXepDuoc<PhanSo2>
{
    List<PhanSo2> phanSoList;
    public  MangPhanSo()
    {
        phanSoList = new ArrayList<PhanSo2>();
    }
    public void Nhap(Scanner sc)
    {
        int n;
        System.out.print("Nhập số lượng phân số: ");
        while (!sc.hasNextInt())
        {
            System.out.println("Lỗi vui lòng nhập lại số lượng phân số: ");
            sc.next();
            System.out.print("Nhập số lượng phân số: ");
        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.println("Nhập phân số " + (i + 1));
            PhanSo2 ps = new PhanSo2();
            ps.Nhap(sc);
            phanSoList.add(ps);
        }
    }

    public void Xuat()
    {
        for (PhanSo2 phanSo2 : phanSoList)
        {
            System.out.print("Phân số :");
            phanSo2.Xuat();
        }
    }

    @Override
    public void SapXepGiamDan() {
        phanSoList.sort((a,b) -> b.soSanh(b,a));

    }

    @Override
    public void SapXepTangDan() {
        phanSoList.sort((a,b) -> a.soSanh(a,b));

    }

    @Override
    public PhanSo2 Max() {
        return phanSoList.stream().max((a,b) -> a.soSanh(a,b)).orElse(null);
    }

    @Override
    public PhanSo2 Min() {
        return phanSoList.stream().min((a,b) -> a.soSanh(a,b)).orElse(null);
    }
}
public class Bai5 {
    public static void main(String[] args) {
        MangPhanSo mangPhanSo = new MangPhanSo();
        Scanner sc = new Scanner(System.in);
        mangPhanSo.Nhap(sc);
        mangPhanSo.SapXepGiamDan();
        System.out.println("Mảng phân số sau khi sắp xếp giảm dần là:");
        mangPhanSo.Xuat();
        mangPhanSo.SapXepTangDan();
        System.out.println("Mảng phân số sau khi sắp xếp tăng dần là:");
        mangPhanSo.Xuat();
        PhanSo2 max = mangPhanSo.Max();
        PhanSo2 min = mangPhanSo.Min();
        System.out.println("Phân số lớn nhất trong mảng là :" + max);
        System.out.println("Phân số nhỏ nhất trong mảng là :" + min);

    }
}
