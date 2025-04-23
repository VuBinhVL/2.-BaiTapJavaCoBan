import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien1 implements Comparable<SinhVien1>
{
    private String hoTen;
    private double diemTB;
    public void Nhap(Scanner sc)
    {
        System.out.print("Họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Điểm TB: ");
        diemTB = sc.nextDouble();
        sc.nextLine();
    }
    @Override
    public int compareTo(SinhVien1 o) {
        return Double.compare(diemTB,o.diemTB);
    }
    @Override
    public String toString() {
        return hoTen + "_" + diemTB;
    }
}
public class Bai_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true)
        {
            System.out.print("Nhập số lượng sinh viên: ");
            if (sc.hasNextInt())
            {
                n = sc.nextInt();
                if (n < 0)
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
        sc.nextLine();

        //Nhập danh sách sinh viên
        ArrayList<SinhVien1> list = new ArrayList<>();
        System.out.println("=== Nhập danh sách sinh viên ===");
        for (int i = 0; i < n; i++)
        {
            System.out.println("Sinh viên thứ " + (i + 1));
            SinhVien1 sinhVien = new SinhVien1();
            sinhVien.Nhap(sc);
            list.add(sinhVien);
        }

        //Sắp xếp và xuất
        SinhVien1 [] svList = list.toArray((new SinhVien1[list.size()]));
        Arrays.sort(svList);
        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        System.out.println(Arrays.toString(svList));
    }
}
