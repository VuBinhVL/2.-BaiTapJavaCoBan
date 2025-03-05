import java.util.Scanner;

public class Bai6 {

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Hàm lấy số ngày trong tháng
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    // Hàm xác định ngày đầu tiên của năm
    public static int getStartDay(int year) {
        int startDay = 1; // 1/1/1900 là thứ Hai
        for (int i = 1900; i < year; i++) {
            startDay = (startDay + (isLeapYear(i) ? 366 : 365)) % 7;
        }
        return startDay;
    }

    // Hàm in lịch tháng
    public static void printMonth(int month, int year, int startDay) {
        String[] monthNames = {
                "", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6",
                "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"
        };

        System.out.println("\n" + monthNames[month] + " " + year);
        System.out.println("CN T2 T3 T4 T5 T6 T7");

        int daysInMonth = getDaysInMonth(month, year);

        // In khoảng trắng cho ngày bắt đầu
        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        // In các ngày trong tháng
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);

            if ((startDay + day) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập năm: ");
        int year = sc.nextInt();

        int startDay = getStartDay(year);

        for (int month = 1; month <= 12; month++) {
            printMonth(month, year, startDay);
            startDay = (startDay + getDaysInMonth(month, year)) % 7;
        }

        sc.close();
    }
}
