import java.util.Scanner;

class PhanSo
{
    int tuso, mauso;
    public PhanSo()
    {
        this.tuso = 1;
        this.mauso = 1;
    }
    public PhanSo (int t, int m)
    {
        if (m == 0)
        {
            return;
        }
        this.tuso = t;
        this.mauso = m;
    }

    public PhanSo (PhanSo a)
    {
        this.tuso = a.tuso;
        this.mauso = a.mauso;
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
        this.tuso = sc.nextInt();

        System.out.print("Nhập mẫu số: ");
        while (true)
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Lỗi vui lòng nhập lại mẫu số");
                sc.next();
                System.out.print("Nhập mẫu số: ");
            }
            this.mauso = sc.nextInt();
            if (this.mauso != 0)
            {
                break;
            }
            System.out.println("Lỗi mẫu số phải khác 0!");
            System.out.print("Nhập mẫu số: ");
        }
    }

    public  void Xuat()
    {
        System.out.println(tuso + "/" + mauso);
    }

    public int uocChungLonNhat(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        while(b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void rutGon()
    {
        int ucln = uocChungLonNhat(tuso, mauso);
        tuso = tuso / ucln;
        mauso = mauso / ucln;
    }

    public PhanSo Cong(PhanSo phanso)
    {
        PhanSo rs = new PhanSo();
        rs.tuso = this.tuso * phanso.mauso + this.mauso * phanso.tuso;
        rs.mauso = this.mauso * phanso.mauso;
        return rs;
    }

    public PhanSo Tru(PhanSo phanso)
    {
        PhanSo rs = new PhanSo();
        rs.tuso = this.tuso * phanso.mauso - this.mauso * phanso.tuso;
        rs.mauso = this.mauso * phanso.mauso;
        return rs;
    }

    public PhanSo Nhan(PhanSo phanso)
    {
        PhanSo rs = new PhanSo();
        rs.tuso = this.tuso * phanso.tuso;
        rs.mauso = this.mauso * phanso.mauso;
        return rs;
    }

    public PhanSo Chia(PhanSo phanso)
    {
        PhanSo rs = new PhanSo();
        rs.tuso = this.tuso * phanso.mauso;
        rs.mauso = this.mauso * phanso.tuso;
        return rs;
    }

    public int soSanh(PhanSo phanso)
    {
        float ps1 = (float)(tuso / mauso);
        float ps2 = (float)(phanso.tuso / phanso.mauso);
        if (ps1 > ps2)
            return 1;
        else if (ps1 < ps2)
            return -1;
        return 0;
    }

    //Bubble sort
    public static void sapXepTangDan (PhanSo [] phanSo)
    {
        int n = phanSo.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)
            {
                if (phanSo[j].soSanh(phanSo[j+1]) > 0)
                {
                    PhanSo temp = phanSo[j];
                    phanSo[j] = phanSo[i];
                    phanSo[i] = temp;
                }
            }
    }



}
public class Bai3 {
    public static void main(String[] args) {
        int n;
        PhanSo tong = new PhanSo(0,1);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phân số: ");
        while (!sc.hasNextInt())
        {
            System.out.println("Lỗi vui lòng nhập lại số lượng phân số: ");
            sc.next();
            System.out.print("Nhập số lượng phân số: ");
        }
        n = sc.nextInt();
        PhanSo [] phanSo = new PhanSo [n];
        for (int i = 0; i < n; i++)
        {
            System.out.println("Nhập phân số " + (i + 1));
            phanSo[i] = new PhanSo();
            phanSo[i].Nhap(sc);
            tong = tong.Cong(phanSo[i]);
        }

        System.out.println("Mảng phân số vừa nhập là: " );
        for (int i = 0; i < n; i++)
        {
            System.out.print("Phân số " + (i + 1) + " :");
            phanSo[i].Xuat();
        }
        System.out.print("Tổng các phân số trong mảng là: " );
        tong.rutGon();
        tong.Xuat();
        PhanSo.sapXepTangDan(phanSo);
        System.out.println("Mảng phân số sau khi sắp xếp tăng dần là: " );
        for (int i = 0; i < n; i++)
        {
            System.out.print("Phân số " + (i + 1) + " :");
            phanSo[i].Xuat();
        }

    }
}
