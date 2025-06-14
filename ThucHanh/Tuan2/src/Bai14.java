import java.util.Scanner;
class WebAddressException extends Exception {
    public WebAddressException(String message) {
        super(message);
    }
}


public class Bai14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập địa chỉ website: ");
        String url = sc.nextLine().trim();

        try {
            validateUrl(url);
            System.out.println("Địa chỉ web hợp lệ: " + url);
        } catch (WebAddressException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm kiểm tra định dạng địa chỉ web
    public static void validateUrl(String url) throws WebAddressException {
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            throw new WebAddressException("Địa chỉ web phải bắt đầu bằng 'http://' hoặc 'https://'");
        }

        if (!url.contains(".")) {
            throw new WebAddressException("Địa chỉ web phải chứa dấu '.' (VD: .com, .org, ...)");
        }
    }
}

