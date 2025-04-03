import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Bai_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày, tháng, năm
        System.out.print("Nhập ngày (dd/MM/yyyy): ");
        String ngayNhap = scanner.nextLine();

        // Định dạng ngày
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Chuyển đổi chuỗi thành LocalDate
            LocalDate ngay = LocalDate.parse(ngayNhap, dinhDang);

            // Lấy thứ trong tuần
            DayOfWeek thu = ngay.getDayOfWeek();

            // Hiển thị kết quả
            System.out.println("Ngày " + ngay + " là " + doiThuSangTiengViet(thu));

        } catch (Exception e) {
            System.out.println("Định dạng ngày không hợp lệ!");
        }

        scanner.close();
    }

    // Chuyển đổi thứ sang tiếng Việt
    public static String doiThuSangTiengViet(DayOfWeek thu) {
        switch (thu) {
            case MONDAY:    return "Thứ Hai";
            case TUESDAY:   return "Thứ Ba";
            case WEDNESDAY: return "Thứ Tư";
            case THURSDAY:  return "Thứ Năm";
            case FRIDAY:    return "Thứ Sáu";
            case SATURDAY:  return "Thứ Bảy";
            case SUNDAY:    return "Chủ Nhật";
            default:        return "Không xác định";
        }
    }
}
