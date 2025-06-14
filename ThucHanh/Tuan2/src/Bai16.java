import java.util.Scanner;
class PINException extends Exception {
    public PINException(String message) {
        super(message);
    }
}

public class Bai16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã PIN (4 chữ số): ");
        String input = sc.nextLine().trim();

        try {
            validatePIN(input);
            System.out.println("PIN hợp lệ: " + input);
        } catch (PINException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm kiểm tra định dạng PIN
    public static void validatePIN(String pin) throws PINException {
        if (pin.length() != 4 || !pin.matches("\\d{4}")) {
            throw new PINException("PIN không hợp lệ! Phải gồm đúng 4 ký số (0-9).");
        }
    }
}
