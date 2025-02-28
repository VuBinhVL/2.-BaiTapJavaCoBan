import java.util.Scanner;

public class Bai_009 {
    public static void main(String[] args) {
        int n;
        float r;
        System.out.print("Nhập số cạnh đa giác nội tiếp đường tròn: ");
        n = new Scanner(System.in).nextInt();
        System.out.print("Nhập bán kính đường tròn: ");
        r = new Scanner(System.in).nextFloat();
        double s = (n * r * r * Math.sin(Math.PI * 2 / r)) / 2;
        System.out.println("Diện tích của đa giác đều nội tiếp đường tròn là: " + s);
        }
}
