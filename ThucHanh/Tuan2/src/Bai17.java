import java.util.Scanner;

class PhoneException extends Exception {
    public PhoneException(String message) {
        super(message);
    }
}


public class Bai17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String input = sc.nextLine().trim();

        try {
            validatePhone(input);
            System.out.println("Số điện thoại hợp lệ: " + input);
        } catch (PhoneException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm kiểm tra số điện thoại
    public static void validatePhone(String phone) throws PhoneException {
        if (!phone.matches("0\\d{9}")) {
            throw new PhoneException("Số điện thoại không hợp lệ! Phải gồm đúng 10 chữ số và bắt đầu bằng số 0.");
        }
    }
}

