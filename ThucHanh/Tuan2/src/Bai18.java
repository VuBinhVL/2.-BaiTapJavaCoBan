import java.util.Scanner;

class TriangleEdgesException extends Exception {
    public TriangleEdgesException(String message) {
        super(message);
    }
}

public class Bai18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập cạnh a: ");
            double a = Double.parseDouble(sc.nextLine());

            System.out.print("Nhập cạnh b: ");
            double b = Double.parseDouble(sc.nextLine());

            System.out.print("Nhập cạnh c: ");
            double c = Double.parseDouble(sc.nextLine());

            validateTriangle(a, b, c);
            System.out.println("Ba cạnh hợp lệ tạo thành tam giác.");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        } catch (TriangleEdgesException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm kiểm tra hợp lệ tam giác
    public static void validateTriangle(double a, double b, double c) throws TriangleEdgesException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleEdgesException("Các cạnh phải là số dương lớn hơn 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdgesException("Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
