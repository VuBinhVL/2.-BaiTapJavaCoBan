import java.util.Scanner;

public class Bai_004 {
    public static void main(String[] args) {
        float r;
        System.out.print("Nhập bán kính hình cầu: ");
        r = new Scanner(System.in).nextFloat();
        double p =  4*Math.PI*r*r;
        System.out.println("Diện tích xung quanh hình cầu là:" + p);
    }
}
