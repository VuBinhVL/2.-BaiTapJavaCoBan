import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Bai_16 {
    public static void main(String[] args) {
        String inputFile = "data15.txt";
        String outputFile = "output15.txt";

        try (Stream<String> lines = Files.lines(Paths.get(inputFile));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {

            // Xử lý dữ liệu bằng Lambda
            lines.filter(line -> !line.trim().isEmpty()) // Loại bỏ dòng trống
                    .map(String::toUpperCase) // huyển sang chữ in hoa
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine(); // Xuống dòng sau mỗi dòng
                        } catch (IOException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    });

            System.out.println("Dữ liệu đã được xử lý và ghi vào 'output15.txt'.");

        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý tệp: " + e.getMessage());
        }
    }
}
