import java.util.Scanner;

class UnsignedIntegerException extends Exception {
    public UnsignedIntegerException(String message) {
        super(message);
    }
}


public class Bai13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String input = sc.nextLine();

        try {
            int number = Integer.parseInt(input.trim());

            if (number <= 0) {
                throw new UnsignedIntegerException("Lỗi: Không phải số nguyên dương.");
            }

            System.out.println("Số nguyên dương hợp lệ: " + number);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Chuỗi không đúng định dạng số nguyên.");
        } catch (UnsignedIntegerException e) {
            System.out.println(e.getMessage());
        }
    }
}
