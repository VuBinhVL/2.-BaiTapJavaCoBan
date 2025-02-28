import java.util.Scanner;

public class Bai_008 {
    public static void main(String[] args) {
        int n;
        float r;
        System.out.print("Nhập số cạnh đa giác nội tiếp đường tròn: ");
        n = new Scanner(System.in).nextInt();
        System.out.print("Nhập bán kính đường tròn: ");
        r = new Scanner(System.in).nextFloat();
        double p = 2 * n * r * Math.sin( Math.PI / n );
        System.out.println("Chu vi đa giác đều nội tiếp đường tròn là: " + p);
    }
}
