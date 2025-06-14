import java.io.*;
import java.util.*;

public class Bai3_1 {
    //Văn bản
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập x: ");
        int x = sc.nextInt();

        // Đọc toàn bộ file c.txt vào list
        List<Integer> list = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("c.txt"))) {
            while (fileScanner.hasNextInt()) {
                list.add(fileScanner.nextInt());
            }
        }

        // Kiểm tra x có trong danh sách hay không
        if (list.contains(x)) {
            System.out.println("X có tồn tại trong c.txt");
        } else {
            System.out.println("X không tồn tại trong c.txt");
        }
    }
}
