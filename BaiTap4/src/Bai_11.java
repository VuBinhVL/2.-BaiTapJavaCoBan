import java.util.ArrayList;
import java.util.List;

class GenericList<T> {
    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    // Thêm phần tử vào danh sách
    public void add(T item) {
        list.add(item);
    }

    // Xóa phần tử khỏi danh sách
    public void remove(T item) {
        if (list.contains(item)) {
            list.remove(item);
        } else {
            System.out.println("Phần tử không tồn tại trong danh sách.");
        }
    }

    // Kiểm tra danh sách có chứa phần tử hay không
    public boolean contains(T item) {
        return list.contains(item);
    }

    // Hiển thị danh sách
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Danh sách: " + list);
        }
    }
}

public class Bai_11 {
    public static void main(String[] args) {
        // Kiểm thử với danh sách số nguyên
        System.out.println("Kiểm thử với danh sách số nguyên:");
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
        System.out.println("\nKiểm thử với danh sách chuỗi:");
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
