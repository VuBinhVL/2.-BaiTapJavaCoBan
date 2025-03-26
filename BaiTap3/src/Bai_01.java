import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password, email;
        //Nhập email
        while (true)
        {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            if ( checkEmail(email) )
            {
                break;
            }
            else
            {
                System.out.println("Email không hợp lệ! Hãy nhập lại.");
            }
        }

        //Nhập pass
        while (true)
        {
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            if ( checkPassword(password) )
            {
                break;
            }
            else
            {
                System.out.println("Password không hợp lệ! Hãy nhập lại.");
            }
        }
        System.out.println("Đăng ký thành công!");
    }

    //Hàm kiểm tra email
    public static boolean checkEmail (String email)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
        if (p.matcher(email).find())
        {
            return true;
        }
        return false;
    }

    //Hàm kiểm tra pass
    public static boolean checkPassword (String pass)
    {
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$");
        if (p.matcher(pass).find())
        {
            return true;
        }
        return false;
    }
}
