import java.util.Scanner;

public class Bai_003 {
    public static void main(String[] args) {
        float r;
        System.out.print("Nhập bán kính R: ");
        r = new Scanner(System.in).nextFloat();
        double cv = Math.PI*2*r;
        System.out.print("Chu vi đường tròn là: "+ cv);
    }
}
