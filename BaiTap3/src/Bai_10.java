import java.util.*;

class GiaiMeCung {
    // Di chuyển theo 4 hướng (Lên, Xuống, Trái, Phải)
    static int[] dichX = {-1, 1, 0, 0};
    static int[] dichY = {0, 0, -1, 1};

    static class O {
        int hang, cot, buoc;
        O(int hang, int cot, int buoc) {
            this.hang = hang;
            this.cot = cot;
            this.buoc = buoc;
        }
    }

    public static int timDuongNganNhat(char[][] meCung, int xBatDau, int yBatDau, int xDich, int yDich) {
        int soHang = meCung.length, soCot = meCung[0].length;
        boolean[][] daDuyet = new boolean[soHang][soCot];
        Queue<O> hangDoi = new LinkedList<>();

        hangDoi.add(new O(xBatDau, yBatDau, 0));
        daDuyet[xBatDau][yBatDau] = true;

        while (!hangDoi.isEmpty()) {
            O hienTai = hangDoi.poll();

            // Nếu đến đích, trả về số bước
            if (hienTai.hang == xDich && hienTai.cot == yDich) {
                return hienTai.buoc;
            }

            // Duyệt 4 hướng
            for (int i = 0; i < 4; i++) {
                int hangMoi = hienTai.hang + dichX[i];
                int cotMoi = hienTai.cot + dichY[i];

                if (hangMoi >= 0 && cotMoi >= 0 && hangMoi < soHang && cotMoi < soCot &&
                        meCung[hangMoi][cotMoi] == '.' && !daDuyet[hangMoi][cotMoi]) {
                    hangDoi.add(new O(hangMoi, cotMoi, hienTai.buoc + 1));
                    daDuyet[hangMoi][cotMoi] = true;
                }
            }
        }
        return -1; // Không tìm thấy đường đi
    }

    public static void main(String[] args) {
        char[][] meCung = {
                { '#', '#', '#', '#', '#', '#', '#' },
                { '#', '.', '.', '.', '#', '.', '#' },
                { '#', '.', '#', '.', '#', '.', '#' },
                { '#', '.', '#', '.', '.', '.', '#' },
                { '#', '#', '#', '#', '#', '#', '#' }
        };

        int xBatDau = 1, yBatDau = 1;
        int xDich = 3, yDich = 5;

        int ketQua = timDuongNganNhat(meCung, xBatDau, yBatDau, xDich, yDich);

        if (ketQua != -1) {
            System.out.println("Đường đi ngắn nhất: " + ketQua + " bước");
        } else {
            System.out.println("Không có đường đi!");
        }
    }
}
