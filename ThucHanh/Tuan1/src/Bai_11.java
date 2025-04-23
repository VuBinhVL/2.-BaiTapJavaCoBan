import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class BaiHat
{
    private String maBaiHat;
    private String tenBaiHat;
    private String caSi;

    public void nhap(Scanner sc) {
        System.out.print("Nhập mã bài hát: ");
        maBaiHat = sc.nextLine();
        System.out.print("Nhập tên bài hát: ");
        tenBaiHat = sc.nextLine();
        System.out.print("Nhập tên ca sĩ: ");
        caSi = sc.nextLine();
    }

    @Override
    public String toString() {
        return maBaiHat + "_" + tenBaiHat + "_" + caSi;
    }
}
public class Bai_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. Nhập vào một bài hát và lưu vào file “baihat.txt” sử dụng Filewriter.
        BaiHat bh = new BaiHat();
        bh.nhap(sc);
        try (FileWriter fileWriter = new FileWriter("baihat.txt"))
        {
            fileWriter.write(bh.toString());
            System.out.println("Đã ghi vào file baihat.txt thành công");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        //Nhập vào danh sách các bài hát và lưu vào file “danhsachbaihat.txt” bằng cách sử dụng BufferedWriter.
        ArrayList<BaiHat> list = new ArrayList<>();
        int n;
        while (true) {
            System.out.print("Nhập số lượng bài hát: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Số lượng phải > 0");
                    sc.nextLine();
                } else
                    break;
            } else {
                System.out.println("Phải nhập số");
                sc.nextLine();
            }
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Bài hát thứ " + (i + 1));
            BaiHat baiHat = new BaiHat();
            baiHat.nhap(sc);
            list.add(baiHat);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("danhsachbaihat.txt")))
        {
            for (BaiHat song: list) {
                bufferedWriter.write(song.toString());
                bufferedWriter.newLine();
            }
            System.out.println("Đã ghi danh sách bài hát vào file thành công");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
