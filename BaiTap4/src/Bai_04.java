import java.util.*;

public class  Bai_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập số lượng dãy số
        System.out.print("Nhập số lượng dãy số: ");
        int soLuongDay = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> danhSachDaySo = new ArrayList<>();
        Set<Integer> tapHopChung = null;

        // Bước 2: Đọc từng dãy số và lưu vào danh sách
        for (int i = 0; i < soLuongDay; i++) {
            System.out.println("Nhập dãy số thứ " + (i+1));
            String[] mangSo = scanner.nextLine().split(" ");
            List<Integer> daySo = new ArrayList<>();
            Set<Integer> tapHopTamThoi = new HashSet<>();

            for (String so : mangSo) {
                int giaTri = Integer.parseInt(so);
                daySo.add(giaTri);
                tapHopTamThoi.add(giaTri);
            }

            danhSachDaySo.add(daySo);

            // Xác định tập hợp các phần tử chung
            if (tapHopChung == null) {
                tapHopChung = new HashSet<>(tapHopTamThoi);
            } else {
                tapHopChung.retainAll(tapHopTamThoi); //Giúp giữ các phần tử chung giữa 2 tập hợp vào tapHopChung
            }
        }

        int stt = 1;
        // Bước 3: Loại bỏ các phần tử thuộc dãy con chung khỏi từng dãy số
        for (List<Integer> daySo : danhSachDaySo) {
            List<Integer> daySoSauKhiLoc = new ArrayList<>();
            for (int so : daySo) {
                if (!tapHopChung.contains(so)) {
                    daySoSauKhiLoc.add(so);
                }
            }

            // Xuất kết quả
            System.out.print("Dãy số thứ " + stt + " sau khi lọc là: ");
            stt++;
            System.out.println(daySoSauKhiLoc.toString().replaceAll("[\\[\\]]", ""));
        }

        scanner.close();
    }
}
