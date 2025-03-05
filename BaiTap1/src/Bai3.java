import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        int [] a;
        int n;
        System.out.print("Nhập n số nguyên: ");
        n = new Scanner(System.in).nextInt();
        a = new int[n];
        //Nhập mảng
        for (int i = 0; i < n; i ++)
        {
            a[i] = new Scanner(System.in).nextInt();
        }
        //Sắp xếp theo thứ tự tăng dần
        for (int i = 0; i<n-1; i++)
        {
            for (int j = i + 1; j<n;j++)
            {
                if (a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        //Xuất mảng
        System.out.print("Mảng sau khi sắp xếp tăng dần là: ");
        for (int i = 0; i<n; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
