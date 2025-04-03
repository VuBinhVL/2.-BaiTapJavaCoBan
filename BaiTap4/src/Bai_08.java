import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày giờ từ bàn phím
        System.out.print("Nhập ngày giờ (dd/MM/yyyy HH:mm:ss): ");
        String ngayGioNhap = scanner.nextLine();

        // Nhập múi giờ đích (ví dụ: 8 nếu muốn GMT+8)
        System.out.print("Nhập múi giờ muốn chuyển đến (VD: 8 cho GMT+8, -5 cho GMT-5): ");
        int chenhLechMuiGio = scanner.nextInt();

        // Định dạng ngày giờ
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try {
            // Chuyển đổi chuỗi nhập vào thành LocalDateTime
            LocalDateTime ngayGio = LocalDateTime.parse(ngayGioNhap, dinhDang);

            // Mặc định múi giờ Việt Nam là GMT+7
            ZoneId zoneVietNam = ZoneId.of("Asia/Ho_Chi_Minh");
            ZonedDateTime ngayGioVN = ngayGio.atZone(zoneVietNam);

            // Tính toán múi giờ mới dựa trên chênh lệch
            ZoneId zoneMoi = ZoneId.ofOffset("GMT", java.time.ZoneOffset.ofHours(chenhLechMuiGio));
            ZonedDateTime ngayGioMoi = ngayGioVN.withZoneSameInstant(zoneMoi);

            // Hiển thị kết quả
            System.out.println("Ngày giờ ở Việt Nam: " + ngayGioVN.format(dinhDang));
            System.out.println("Ngày giờ ở GMT" + (chenhLechMuiGio >= 0 ? "+" : "") + chenhLechMuiGio + ": " + ngayGioMoi.format(dinhDang));

        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu! Vui lòng nhập đúng định dạng.");
        }

        scanner.close();
    }
}
