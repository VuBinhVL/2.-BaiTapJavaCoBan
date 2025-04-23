class MyMath
{
    //Ước chung lớn nhất
    public static int gCD(int a, int b)
    {
        while (b!=0)
        {
            int temp = a % b;
            a = b;
            b= temp;
        }
        return a;
    }

    //Max giữa 3 số thực
    public static double max (double a,double b,double c)
    {
        return Math.max(a, Math.max(b,c));
    }

    //Min giữa 3 số thực
    public static double min (double a,double b,double c)
    {
        return Math.min(a, Math.min(b,c));
    }

    //Kiểm tra số nguyên tố
    public static boolean kiemTraSNT (int a)
    {
        if (a < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(a); i++)
            if ( a % i == 0)
                return false;
        return true;
    }
    // Tính tổng từ 1 đến N
    public static int sumN(int n)
    {
        return (n + 1) * n / 2;
    }

    //Giá trị tuyệt đối của 1 số nguyên
    public static int abs (int n)
    {
        return Math.abs(n);
    }

    //Giá trị làm tròn của 1 số thực
    public static long round (double n)
    {
        return Math.round(n);
    }
}
public class Bai_06 {
    public static void main(String[] args) {
        System.out.println("GCD của 18 và 24 là: " + MyMath.gCD(18, 24));
        System.out.println("Max của 1.2, 4.5, 3.3 là: " + MyMath.max(1.2, 4.5, 3.3));
        System.out.println("Min của 1.2, 4.5, 3.3 là: " + MyMath.min(1.2, 4.5, 3.3));
        System.out.println("Số 17 có phải là số nguyên tố không? " + MyMath.kiemTraSNT(17));
        System.out.println("Tổng từ 1 đến 10 là: " + MyMath.sumN(10));
        System.out.println("Trị tuyệt đối của -12 là: " + MyMath.abs(-12));
        System.out.println("Làm tròn 3.56 là: " + MyMath.round(3.56));
    }
}
