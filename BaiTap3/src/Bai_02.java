import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url ;
        //Nhập email
        while (true)
        {
            System.out.print("Nhập url: ");
            url = sc.nextLine();
            if ( checkURL(url) )
            {
                break;
            }
            else
            {
                System.out.println("URL không hợp lệ! Hãy nhập lại.");
            }
        }
        System.out.println("URL hợp lệ");

    }

    public static boolean checkURL (String url)
    {
        Pattern p = Pattern.compile("^(https?://)[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+(/.*)?$");
        if (p.matcher(url).find())
        {
            return true;
        }
        return false;
    }
}
