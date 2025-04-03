import java.util.Scanner;

public class Bai_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = scanner.nextLine();
        hoTen = hoTen.trim().toUpperCase(); // Xóa khoảng trắng & chuyển chữ hoa

        // Nhập mã đặt chỗ
        System.out.print("Nhập mã đặt chỗ: ");
        StringBuffer maDatCho = new StringBuffer(scanner.nextLine().toUpperCase());
        while (maDatCho.length() < 6)
        {
            maDatCho.insert(0,"0");
        }
        String maDatChoChuanHoa = maDatCho.toString().replaceAll("[^A-Z0-9]","-");
        System.out.println("Mã đặt chỗ sau khi xử lý là: " + maDatChoChuanHoa);

        //Tạo chuỗi StringBuffer
        StringBuffer thongtin = new StringBuffer();
        thongtin.append("Hàng khách: ").append(hoTen).append("\n");
        thongtin.append("Mã đặt chỗ: ").append(maDatChoChuanHoa).append("\n");

        //Hiển thị thông tin
        System.out.println("=== Thông tin hàng khách ====");
        System.out.println(thongtin);

        //Hiển thị thông tin đảo ngược
        System.out.println("=== Thông tin hàng khách sau khi đảo ngược ====");
        System.out.println(thongtin.reverse());
    }
}
