import java.util.Scanner;
class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

public class Bai15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        String input = sc.nextLine().trim();

        try {
            int age = Integer.parseInt(input);

            if (age < 0) {
                throw new AgeException("Tuổi không hợp lệ! Tuổi >= 0");
            }

            System.out.println("Tuổi bạn vừa nhập là: " + age);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ.");
        } catch (AgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
