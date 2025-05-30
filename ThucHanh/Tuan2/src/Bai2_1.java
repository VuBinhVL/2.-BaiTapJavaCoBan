import java.io.*;
import java.util.*;

public class Bai2_1 {
    public static void main(String[] args) throws IOException {
        // 1. Đọc mảng A từ a.txt
        List<Integer> listA = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("a.txt"))) {
            while (sc.hasNextInt()) {
                listA.add(sc.nextInt());
            }
        }
        int[] A = listA.stream().mapToInt(i -> i).toArray();
        int n = A.length;

        // 2. Tạo mảng B gồm m phần tử ngẫu nhiên
        int m = 10;
        int[] B = new int[m];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            B[i] = rand.nextInt(100);
        }

        // Ghi B ra b.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"))) {
            for (int x : B) {
                bw.write(x + " ");
            }
        }

        // 3. Copy A vào C
        List<Integer> listC = new ArrayList<>();
        for (int x : A) listC.add(x);

        // 4. Thay phần tử thứ 13 bằng 3 phần tử cuối của B
        if (listC.size() >= 13 && B.length >= 3) {
            listC.remove(12); // chỉ xóa phần tử thứ 13 (vị trí 12)
            listC.add(12, B[m - 3]);
            listC.add(13, B[m - 2]);
            listC.add(14, B[m - 1]);
        }

        // 5. Sắp xếp C và ghi ra c.txt
        int[] C = listC.stream().mapToInt(i -> i).toArray();
        Arrays.sort(C);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"))) {
            for (int x : C) {
                bw.write(x + " ");
            }
        }

        System.out.println("Đã xử lý xong dạng văn bản.");
    }
}
