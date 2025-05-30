import java.io.*;
import java.util.*;

public class Bai2_2 {
    //Nhị phân
    public static void main(String[] args) throws IOException {
        // 1.
        List<Integer> listA = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("a.txt"))) {
            while (dis.available() > 0) {
                listA.add(dis.readInt());
            }
        }
        int[] A = listA.stream().mapToInt(i -> i).toArray();
        int n = A.length;

        // 2. Tạo B ngẫu nhiên và ghi ra b.txt
        int m = 10;
        int[] B = new int[m];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            B[i] = rand.nextInt(100);
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("b.txt"))) {
            for (int x : B) {
                dos.writeInt(x);
            }
        }

        // 3. Copy A → C
        List<Integer> listC = new ArrayList<>();
        for (int x : A) listC.add(x);

        // 4. Thay phần tử 13 bằng 3 phần tử cuối của B
        if (listC.size() >= 13 && B.length >= 3) {
            listC.remove(12);
            listC.add(12, B[m - 3]);
            listC.add(13, B[m - 2]);
            listC.add(14, B[m - 1]);
        }

        // 5. Sắp xếp và ghi ra c.txt
        int[] C = listC.stream().mapToInt(i -> i).toArray();
        Arrays.sort(C);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("c.txt"))) {
            for (int x : C) {
                dos.writeInt(x);
            }
        }

        System.out.println("Đã xử lý xong dạng nhị phân.");
    }
}
