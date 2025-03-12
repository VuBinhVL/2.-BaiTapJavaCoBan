import java.util.Scanner;

class Point2D
{
    private float x,y;
    //Phương thức khởi tạo
    Point2D()
    {
        x = 0;
        y = 0;
    }

    //Các get, set
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    //Phương thức tính khoảng cách
    public  double  getDistance (Point2D b)
    {
        return Math.sqrt(Math.pow(this.x-b.x,2) + Math.pow(this.y-b.y,2));
    }

    //Phương thức di chuyển
    public void Move (float a, float b)
    {
        this.x= this.x+a;
        this.y= this.y+b;
    }

    //Phương thức nhập
    public void Input (Scanner s)
    {
        System.out.print("Nhập tọa độ x: ");
        //Kiểm tra lỗi nhập
        while (!s.hasNextFloat())
        {
            System.out.println("Lỗi vui lòng nhập lại tọa độ x.");
            s.next();
            System.out.print("Nhập tọa độ x: ");
        }
        this.x = s.nextFloat();

        System.out.print("Nhập tọa độ y: ");
        while (!s.hasNextFloat())
        {
            System.out.println("Lỗi vui lòng nhập lại tọa độ y.");
            s.next();
            System.out.print("Nhập tọa độ y: ");
        }
        this.y = s.nextFloat();
    }

    //Phương thức xuất
    public void Output ()
    {
        System.out.println("x: " + this.x + ", y: " + this.y);
    }

}

public class Bai1 {
    public static void main(String[] args) {
        Point2D [] a = new Point2D[2];
        Scanner s = new Scanner(System.in);
        float x, y;
        for(int i = 0; i < 2; i++)
        {
            a[i] = new Point2D();
            System.out.println("Nhập tọa độ điểm thứ " + ( i+1));
            a[i].Input(s);
        }

        System.out.println("Nhập tọa độ vector");
        System.out.print("Nhập tọa độ x: ");
        while (!s.hasNextFloat())
        {
            System.out.println("Lỗi vui lòng nhập lại tọa độ x.");
            s.next();
            System.out.print("Nhập tọa độ x: ");
        }
        x = s.nextFloat();

        System.out.print("Nhập tọa độ y: ");
        while (!s.hasNextFloat())
        {
            System.out.println("Lỗi vui lòng nhập lại tọa độ y.");
            s.next();
            System.out.print("Nhập tọa độ y: ");
        }
        y = s.nextFloat();

        //Xuất
        System.out.println("Khoảng cách giữa 2 điểm là: " + a[0].getDistance(a[1]));
        for (int i =0; i<2; i++)
        {
            a[i].Move(x,y);
            System.out.print("Tọa độ điểm thứ "+ (i+1) + " sau khi di chuyển là ");
            a[i].Output();
        }
    }
}
