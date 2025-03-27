import java.io.*;

public class Bai_03 {
    public static void main(String[] args) {
        String fileName = "output.txt";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            //Nhập chuỗi
            System.out.print("Nhập nội dung cần ghi vào tệp: ");
            String text = reader.readLine();

            //Ghi chuỗi
            writer.write(text);
            writer.newLine(); //Xuống dòng khi ghi tệp == /n
            System.out.println("Đã ghi dữ liệu vào tệp");
        }
        catch (IOException e)
        {
            System.out.println("Lỗi khi ghi tệp: "+ e.getMessage());
        }

        //Đọc tệp output.txt
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            System.out.println("Nội dung trong tệp output.txt là: ");
            String line;
            while ((line = reader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }
}
