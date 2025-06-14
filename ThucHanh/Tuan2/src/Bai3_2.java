import java.io.*;
import java.util.Scanner;

public class Bai3_2 {
    //Nhị phân
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập x: ");
        int x = sc.nextInt();

        boolean found = false;

        // Duyệt file nhị phân từng phần tử và kiểm tra
        try (DataInputStream dis = new DataInputStream(new FileInputStream("c.txt"))) {
            while (dis.available() > 0) {
                int value = dis.readInt();
                if (value == x) {
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("X có tồn tại trong c.txt");
        } else {
            System.out.println("X không tồn tại trong c.txt");
        }
    }
}
