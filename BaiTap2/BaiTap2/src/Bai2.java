import java.util.Scanner;

class Time
{
    private int h,m,s;

    //Pthuc khởi tạo
    Time()
    {
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setS(int s) {
        this.s = s;
    }

    public void Input(Scanner sc)
    {
        int temp;
        System.out.print("Nhập giờ: ");
        while(!sc.hasNextInt() || (temp = sc.nextInt()) > 23 || temp < 0)
        {
            System.out.println("Lỗi vui lòng nhập lại giờ từ 0 đến 23");
            sc.nextLine();
            System.out.print("Nhập giờ: ");
        }
        this.h = temp;

        System.out.print("Nhập phút: ");
        while(!sc.hasNextInt() || (temp = sc.nextInt()) > 59 || temp < 0)
        {
            System.out.println("Lỗi vui lòng nhập lại phút từ 0 đến 59");
            sc.nextLine();
            System.out.print("Nhập phút: ");
        }
        this.m = temp;

        System.out.print("Nhập giây: ");
        while(!sc.hasNextInt() || (temp = sc.nextInt()) > 59 || temp < 0)
        {
            System.out.println("Lỗi vui lòng nhập lại giây từ 0 đến 59");
            sc.nextLine();
            System.out.print("Nhập giây: ");
        }
        this.s = temp;

    }

    public void Output()
    {
        System.out.printf("Thời gian: %02d:%02d:%02d\n",this.h,this.m,this.s);
    }
    //Phương thức tăng 1 giây
    public void addOneSecond()
    {
        this.s++;
        if ( this.s == 60)
        {
            this.s = 0;
            this.m++;
            if( this.m == 60)
            {
                this.h++;
                this.m = 0;
                if (this.h == 24)
                {
                    this.h = 0;
                }
            }
        }

    }

    //Phương thức so sánh thời gian
    public int compareTime (Time a)
    {
        if (this.h > a.h)
        {
            return 1;
        }
        else if (this.h < a.h) {
            return -1;
        }
        else
        {
            if (this.m > a.m)
                return 1;
            else if (this.m < a.m)
                return -1;
            else
            {
                if (this.s > a.s)
                    return 1;
                else if (this.s < a.s)
                    return -1;
                else
                    return 0;
            }
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Time [] times = new Time[2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++)
        {
            times[i] = new Time();
            System.out.println("Nhập thời gian thứ " + (i+1));
            times[i].Input(sc);
        }
        int rs = times[0].compareTime(times[1]);
        if( rs == 0 )
            System.out.println("Thời gian bằng nhau");
        else if (rs == 1)
        {
            times[0].Output();
            times[0].addOneSecond();
           // times[0].Output();
        }
        else
        {
            times[1].Output();
            times[0].addOneSecond();
           // times[0].Output();
        }


    }
}
