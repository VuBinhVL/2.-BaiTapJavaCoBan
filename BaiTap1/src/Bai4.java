import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        int th, nm;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tháng: ");
        th = sc.nextInt();
        System.out.print("Nhập năm: ");
        nm = sc.nextInt();
        //Kiểm tra tháng
        while (th < 1 || th > 12)
        {
            System.out.println("Tháng không hợp lệ. Mời nhập lại tháng: ");
            th = sc.nextInt();
        }
        //Kiểm tra năm
        while (nm < 0)
        {
            System.out.println("Năm không hợp lệ. Mời nhập lại năm: ");
            nm = sc.nextInt();
        }
        //Kiểm tra năm nhuận
        int flag = 0;
        if (nm % 400 == 0)
            flag = 1;
        else if ((nm % 4) == 0 && nm % 100 !=0 )
            flag = 1;

        //Xác định ngày trong tháng
        switch (th)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            {
                System.out.println("Tháng " + th + " có 31 ngày");
                break;
            }
            case 4: case 6: case 9: case 11: {
                System.out.println("Tháng " + th + " có 30 ngày");
                break;
            }
            case 2: {
                if (flag == 1) {
                    System.out.println("Tháng " + th + " có 29 ngày");
                    break;
                }
                System.out.println("Tháng " + th + " có 28 ngày");
                break;
            }
            default:
                break;
        }
        }
    }
