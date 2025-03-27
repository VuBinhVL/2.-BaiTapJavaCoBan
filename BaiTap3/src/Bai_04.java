import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class HocSinh
{
    String id;
    String hoTen;
    float gpa;

    public HocSinh (String iD ,String hoTen, float gPa)
    {
        this.id = iD;
        this.hoTen = hoTen;
        this.gpa = gPa;
    }
}
public class Bai_04 {

    public static void main(String[] args) {
        String fileName = "student.txt";
        List<HocSinh> hocSinhList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine())!= null)
            {
                String [] parts = line.split(",");
                if (parts.length != 3)
                {
                    System.out.println("Dữ liệu định dạng lỗi");
                    continue;
                }
                String id = parts[0].trim();
                String hoTen = parts[1].trim();
                float gpa = Float.parseFloat(parts[2].trim());
                if (gpa < 0 || gpa > 4)
                {
                    System.out.println("GPA không hợp lệ " + line);
                    continue;
                }
                hocSinhList.add(new HocSinh(id,hoTen,gpa));
            }
        }
        catch (IOException e)
        {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }

        //Tìm thông tin học sinh có GPA cao nhất
        HocSinh topHocSinh = hocSinhList.get(0);
        for (HocSinh hs: hocSinhList )
        {
            if (hs.gpa >= topHocSinh.gpa)
                topHocSinh = hs;
        }
        System.out.println("Thông tin học sinh có GPA cao nhất là: ");
        System.out.println("MSSV: " + topHocSinh.id);
        System.out.println("Họ và tên: " + topHocSinh.hoTen);
        System.out.println("GPA: " + topHocSinh.gpa);


    }
}
