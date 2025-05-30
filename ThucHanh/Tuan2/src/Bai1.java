import java.io.BufferedReader;
import java.io.FileReader;

public class Bai1 {
    public static void main(String[] args) {
       try
       {
           BufferedReader bufferedReader = new BufferedReader(new FileReader("Name.txt"));
           StringBuilder content = new StringBuilder();
           String line;
           while ((line = bufferedReader.readLine()) != null) {
               content.append(line).append("");
           }
           bufferedReader.close();
           //Đếm
           String [] sentences = content.toString().split("[.?!]");
           int counter = 0;
           for (String sentence : sentences) {
               if (!sentence.trim().isEmpty()) {
                   counter++;
               }
           }
           System.out.println("Số câu trong file là: " + counter);
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
}
