import java.util.Scanner;

public class Bai_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matKhau;

        // Kiểm tra mật khẩu
        while (true) {
            System.out.print("Nhập mật khẩu: ");
            matKhau = scanner.nextLine();

            if (kiemTraDoManh(matKhau)) {
                break;
            } else {
                System.out.println("Mật khẩu không hợp lệ! Vui lòng nhập lại.");
            }
        }

        // Đảo ngược mật khẩu
        String matKhauDaoNguoc = new StringBuilder(matKhau).reverse().toString();
        System.out.println("Mật khẩu đảo ngược: " + matKhauDaoNguoc);

        // Ẩn một phần mật khẩu
        String matKhauAn = anMatKhau(matKhau);
        System.out.println("Mật khẩu ẩn: " + matKhauAn);

        // Mã hóa đơn giản: thay số bằng 'X'
        String matKhauMaHoa = matKhau.replaceAll("[0-9]", "X");
        System.out.println("Mật khẩu mã hóa: " + matKhauMaHoa);

        scanner.close();
    }

    // Phương thức kiểm tra độ mạnh của mật khẩu
    public static boolean kiemTraDoManh(String matKhau) {
        if (matKhau.length() < 8) {
            System.out.println("Mật khẩu phải có ít nhất 8 ký tự.");
            return false;
        }
        if (!matKhau.matches(".*[A-Z].*")) {
            System.out.println("Mật khẩu phải chứa ít nhất một chữ cái in hoa.");
            return false;
        }
        if (!matKhau.matches(".*[a-z].*")) {
            System.out.println("Mật khẩu phải chứa ít nhất một chữ cái thường.");
            return false;
        }
        if (!matKhau.matches(".*\\d.*")) {
            System.out.println("Mật khẩu phải chứa ít nhất một số.");
            return false;
        }
        if (!matKhau.matches(".*[!@#$%^&*()_+={}:;'<>,.?/].*")) {
            System.out.println("Mật khẩu phải chứa ít nhất một ký tự đặc biệt.");
            return false;
        }
        return true;
    }

    // Phương thức ẩn mật khẩu
    public static String anMatKhau(String matKhau) {
        if (matKhau.length() <= 4) {
            return matKhau; // Nếu mật khẩu quá ngắn, không cần ẩn
        }
        String dau = matKhau.substring(0, 2);
        String cuoi = matKhau.substring(matKhau.length() - 2);
        String giua = "*".repeat(matKhau.length() - 4);
        return dau + giua + cuoi;
    }
}
