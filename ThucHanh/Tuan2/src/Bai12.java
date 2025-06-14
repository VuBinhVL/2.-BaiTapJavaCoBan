import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi số nguyên: ");
        String input = sc.nextLine();

        try {
            int number = Integer.parseInt(input.trim());  // cố gắng chuyển chuỗi sang int
            System.out.println("Giá trị số nguyên là: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Chuỗi bạn nhập không đúng định dạng số nguyên.");
        }
    }
}
