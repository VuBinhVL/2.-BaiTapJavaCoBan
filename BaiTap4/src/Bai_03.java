import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SanPham
{
    String maSP;
    String tenSp;
    float gia;
    int sl;
    public SanPham(String maSP, String tenSp, float gia, int sl)
    {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.gia = gia;
        this.sl = sl;
    }
    @Override
    public String toString()
    {
        return "Mã sản phẩm: " + maSP + ", Tên sản phẩm: " + tenSp
                + ", Giá: " + gia + " VND, Số lượng tồn kho: " + sl;
    }
}

class Kho
{
    List<SanPham> kho = new ArrayList<>();

    //Hiển thị sản phaẩm trong kho
    public void xemKho() {
        if (kho.size() == 0)
        {
            System.out.println("Kho trống rỗng");
            return;
        }
        for (SanPham sp: kho) {
            System.out.println(sp);
        }
    }

    //Thêm sản phẩm vào kho
    public void themSanPham(String maSP, String tenSp, float gia, int sl)
    {
        for (SanPham sp: kho ) {
            if (sp.maSP.equals(maSP))
            {
                System.out.println("Lỗi! Sản phẩm đã tồn tại!");
                return;
            }
        }
        kho.add(new SanPham(maSP, tenSp, gia, sl));
        System.out.println("Thêm sản phẩm thành công!");
    }

    //Xóa sản phẩm khỏi kho
    public void xoaSanPham(String maSP)
    {
        for (SanPham sp: kho ) {
            if (sp.maSP.equals(maSP))
            {
                kho.remove(sp);
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Lỗi! Mã sản phẩm không đúng");
    }

    //Cập nhật giá và số lượng sản phẩm
    public void capNhatSanPham(String maSP, float gia, int sl)
    {
        for (SanPham sp: kho ) {
            if (sp.maSP.equals(maSP))
            {
                sp.gia = gia;
                sp.sl = sl;
                System.out.println("Cập nhật giá và số lượng sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Lỗi! Mã sản phẩm không đúng");
    }

    //Cập nhật giá và số lượng sản phẩm khỏi kho
    public void timKiemSanPham(String keyword)
    {
        boolean daTimThay = false;
        for (SanPham sp: kho ) {
            if (sp.tenSp.toLowerCase().contains(keyword.toLowerCase()))
            {
                daTimThay = true;
                System.out.println(sp);
            }
        }
        if(!daTimThay)
            System.out.println("Không tìm thấy sản phẩm nào phù hợp!");
    }

    //Sắp xếp danh sách sản phẩm theo giá tăng dần
    public void sapXepTheoGia()
    {
        kho.sort((sp1,sp2) -> Float.compare(sp1.gia ,sp2.gia));
        System.out.println("Danh sách sản phẩm sau khi sắp xếp tăng dần theo giá");
        xemKho();
    }

    //Sắp xếp danh sách sản phẩm theo số lượng giảm dần
    public void sapXepTheoSoLuong()
    {
        kho.sort((sp1,sp2) -> Float.compare(sp2.sl ,sp1.sl));
        System.out.println("Danh sách sản phẩm sau khi sắp xếp giảm dần theo số lượng");
        xemKho();
    }

    //Thống kê tổng số lượng và giá trị của kho
    public void thongKe()
    {
        int tongSoLuong = 0;
        float tongGiaTriKho = 0;
        for (SanPham sp: kho) {
            tongSoLuong += sp.sl;
            tongGiaTriKho += sp.gia;
        }
        System.out.println("Tổng số lượng hàng hóa trong kho là: " + tongSoLuong);
        System.out.println("Tổng giá trị hàng trong kho là: " + tongGiaTriKho);
    }

}
public class Bai_03 {
        public static void main(String[] args) {
            Kho kho = new Kho();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Hiển thị danh sách sản phẩm");
                System.out.println("3. Xóa sản phẩm");
                System.out.println("4. Cập nhật thông tin sản phẩm");
                System.out.println("5. Tìm kiếm sản phẩm theo tên");
                System.out.println("6. Sắp xếp danh sách theo giá");
                System.out.println("7. Sắp xếp danh sách theo số lượng tồn kho");
                System.out.println("8. Thống kê");
                System.out.println("9. Thoát");
                System.out.print("Chọn chức năng (1-9): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Xử lý dòng trống

                switch (choice) {
                    case 1:
                        // Thêm sản phẩm
                        System.out.print("Nhập mã sản phẩm: ");
                        String code = scanner.nextLine();
                        System.out.print("Nhập tên sản phẩm: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giá sản phẩm: ");
                        float price = scanner.nextFloat();
                        System.out.print("Nhập số lượng tồn kho: ");
                        int quantity = scanner.nextInt();
                        kho.themSanPham(code, name, price, quantity);
                        break;
                    case 2:
                        // Hiển thị danh sách sản phẩm
                        kho.xemKho();
                        break;
                    case 3:
                        // Xóa sản phẩm
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String deleteCode = scanner.nextLine();
                        kho.xoaSanPham(deleteCode);
                        break;
                    case 4:
                        // Cập nhật thông tin sản phẩm
                        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                        String updateCode = scanner.nextLine();
                        System.out.print("Nhập giá mới: ");
                        float newPrice = scanner.nextFloat();
                        System.out.print("Nhập số lượng mới: ");
                        int newQuantity = scanner.nextInt();
                        kho.capNhatSanPham(updateCode, newPrice, newQuantity);
                        break;
                    case 5:
                        // Tìm kiếm sản phẩm theo tên
                        System.out.print("Nhập từ khóa tìm kiếm: ");
                        String keyword = scanner.nextLine();
                        kho.timKiemSanPham(keyword);
                        break;
                    case 6:
                        // Sắp xếp theo giá
                        kho.sapXepTheoGia();
                        break;
                    case 7:
                        // Sắp xếp theo số lượng tồn kho
                        kho.sapXepTheoSoLuong();
                        break;
                    case 8:
                        // Thống kê
                        kho.thongKe();
                        break;
                    case 9:
                        // Thoát
                        System.out.println("Thoát!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }
}
