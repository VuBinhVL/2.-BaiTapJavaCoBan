import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}

public class Bai_14 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 45),
                new Student("Charlie", 60),
                new Student("David", 30),
                new Student("Eve", 90),
                new Student("Frank", 70)
        );

        // Xử lý danh sách sinh viên
        String result = students.stream()
                .filter(s -> s.score >= 50) // 1. Lọc sinh viên có điểm dưới 50
                .sorted((s1, s2) -> Integer.compare(s2.score, s1.score)) // 2. Sắp xếp giảm dần theo điểm
                .map(s -> new Student(s.name.toUpperCase(), s.score)) // 3. Chuyển tên thành in hoa
                .map(Student::toString) // 4. Chuyển danh sách về dạng chuỗi
                .collect(Collectors.joining(", ", "[", "]")); // 5. Định dạng danh sách

        // Xuất kết quả ra màn hình
        System.out.println(result);
    }
}
