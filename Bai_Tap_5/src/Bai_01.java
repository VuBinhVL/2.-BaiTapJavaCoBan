import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  GenericList<T>
{
    private List<T> list;

    public  GenericList()
    {
        this.list = new ArrayList<>();
    }

    //Hàm thêm
    public void add (T item)
    {
        list.add(item);
    }

    //Hàm xóa
    public void remove (T item)
    {
        if (list.contains(item))
        {
            list.remove(item);
        }
        else
            System.out.println("Không tìm thấy phần tử để xóa");
    }

    //Hàm kiểm tra xem có chứa phần tử không
    public boolean contains(T item)
    {
        if (list.contains(item))
            return true;
        return false;
    }

    //Hàm hiển thị
    public void display()
    {
        for (T item: list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
public class Bai_01 {
    public static void main(String[] args) {
        // Kiểm thử với danh sách số nguyên
        System.out.println("1. Kiểm thử với danh sách số nguyên:");
        GenericList<Integer> intList = new GenericList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        intList.display(); // Hiển thị danh sách
        intList.remove(30); // Xóa phần tử 30
        System.out.println("Sau khi xóa 30:");
        intList.display();
        System.out.println("Danh sách có chứa số 20 không? " + intList.contains(20));

        // Kiểm thử với danh sách chuỗi
        System.out.println("\n2. Kiểm thử với danh sách chuỗi:");
        GenericList<String> strList = new GenericList<>();
        strList.add("Apple");
        strList.add("Banana");
        strList.add("Cherry");
        strList.add("Date");
        strList.add("Elderberry");

        strList.display(); // Hiển thị danh sách

        strList.remove("Cherry"); // Xóa phần tử "Cherry"
        System.out.println("Sau khi xóa 'Cherry':");
        strList.display();

        System.out.println("Danh sách có chứa 'Banana' không? " + strList.contains("Banana"));
    }
}
