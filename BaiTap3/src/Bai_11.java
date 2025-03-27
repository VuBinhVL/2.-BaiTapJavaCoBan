import java.io.*;

public class Bai_11 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = "Hello, this is a test file";

        // Ghi nội dung vào tệp
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Đã ghi vào tệp: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp: " + e.getMessage());
        }

        // Đọc nội dung từ tệp
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Nội dung tệp:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }
}
