import java.util.Random;
import java.util.Scanner;

class TaoMeCung {
    private final int chieuRong, chieuCao;
    private final O[][] meCung;
    private final Random ngauNhien = new Random();

    // Hướng di chuyển: lên, phải, xuống, trái
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {-1, 0, 1, 0};

    // Lớp biểu diễn ô trong mê cung
    private static class O {
        boolean daDuyet = false;
        boolean[] tuong = {true, true, true, true}; // Trên, phải, dưới, trái
    }

    public TaoMeCung(int chieuRong, int chieuCao) {
        this.chieuRong = chieuRong;
        this.chieuCao = chieuCao;
        this.meCung = new O[chieuCao][chieuRong];

        for (int i = 0; i < chieuCao; i++) {
            for (int j = 0; j < chieuRong; j++) {
                meCung[i][j] = new O();
            }
        }
        sinhMeCung(0, 0); // Bắt đầu từ góc trái trên
    }

    // Thuật toán đệ quy backtracking
    private void sinhMeCung(int x, int y) {
        meCung[y][x].daDuyet = true;
        int[] huong = {0, 1, 2, 3};
        tronNgauNhien(huong); // Trộn ngẫu nhiên thứ tự duyệt hướng đi

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[huong[i]];
            int ny = y + dy[huong[i]];

            if (laHopLe(nx, ny)) {
                meCung[y][x].tuong[huong[i]] = false;
                meCung[ny][nx].tuong[(huong[i] + 2) % 4] = false;
                sinhMeCung(nx, ny);
            }
        }
    }

    // Kiểm tra xem có thể đi đến ô tiếp theo không
    private boolean laHopLe(int x, int y) {
        return x >= 0 && x < chieuRong && y >= 0 && y < chieuCao && !meCung[y][x].daDuyet;
    }

    // Trộn ngẫu nhiên một mảng (Dùng để chọn hướng đi ngẫu nhiên)
    private void tronNgauNhien(int[] mang) {
        for (int i = mang.length - 1; i > 0; i--) {
            int chiSo = ngauNhien.nextInt(i + 1);
            int tam = mang[chiSo];
            mang[chiSo] = mang[i];
            mang[i] = tam;
        }
    }

    // In mê cung ra màn hình
    public void inMeCung() {
        for (int i = 0; i < chieuCao; i++) {
            // In hàng trên
            for (int j = 0; j < chieuRong; j++) {
                System.out.print("+");
                System.out.print(meCung[i][j].tuong[0] ? "---" : "   ");
            }
            System.out.println("+");

            // In hàng giữa
            for (int j = 0; j < chieuRong; j++) {
                System.out.print(meCung[i][j].tuong[3] ? "|" : " ");
                System.out.print("   ");
            }
            System.out.println("|");
        }

        // In hàng dưới cùng
        for (int j = 0; j < chieuRong; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mê cung (NxN): ");
        int kichThuoc = scanner.nextInt();
        TaoMeCung meCung = new TaoMeCung(kichThuoc, kichThuoc);
        meCung.inMeCung();
        scanner.close();
    }
}
