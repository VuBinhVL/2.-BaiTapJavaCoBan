import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Bai_10_2 {
    public static void main(String[] args) {
        ArrayList<Double> arrayDouble = new ArrayList<Double>();
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
        Random random = new Random();
        double tong = 0;

        // Tạo 10 số thực ngẫu nhiên từ 0 đến 150
        System.out.println("Các số thực ngẫu nhiên:");
        for(int i = 0; i < 10; i++)
        {
            double a = random.nextDouble() * 150;
            arrayDouble.add(a);
            tong += a;
            System.out.printf("%.2f ",a);
        }

        // Tính trung bình cộng và làm tròn 2 chữ số
        double trungBinhCong = tong / arrayDouble.size();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("\nTrung bình cộng: " + decimalFormat.format(trungBinhCong));

        // Làm tròn các số và đếm số lẻ
        int dem = 0;
        System.out.println("Các số sau khi làm tròn:");
        for (Double db: arrayDouble) {
            int soNguyen = (int) Math.round(db);
            arrayInteger.add(soNguyen);
            System.out.print(soNguyen + " ");
            if (soNguyen % 2 != 0)
                dem++;
        }

        //Thống kê số lẻ
        double tiLeSoLe = (double)dem * 100 / arrayInteger.size();
        System.out.printf("\nSố lẻ chiếm: %.2f%%\n", tiLeSoLe);

    }
}
