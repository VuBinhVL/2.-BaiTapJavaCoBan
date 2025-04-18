import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Event implements Comparable<Event>
{
    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime)
    {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    //Hàm tính thời lượng
    public Duration getDuration()
    {
        return Duration.between(startTime,endTime);
    }

    //Hàm sắp xếp
    @Override
    public int compareTo(Event other)
    {
        return this.getDuration().compareTo(other.getDuration());
    }
    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return String.format("Sự kiện: %s | Bắt đầu: %s | Kết thúc: %s | Thời lượng: %d phút",
                name, startTime, endTime, getDuration().toMinutes());
    }
}


public class Bai_02 {
    public static void main(String[] args) {
        List<Event> eventList = new ArrayList<>();
        //Thêm
        eventList.add(new Event("Họp nhóm", LocalDateTime.of(2024, 4, 5, 14, 0), LocalDateTime.of(2024, 4, 5, 15, 0)));
        eventList.add(new Event("Thuyết trình", LocalDateTime.of(2024, 4, 5, 9, 0), LocalDateTime.of(2024, 4, 5, 10, 30)));
        eventList.add(new Event("Ăn trưa", LocalDateTime.of(2024, 4, 5, 12, 0), LocalDateTime.of(2024, 4, 5, 13, 0)));

        //Hiển thị danh sách sự kiện
        System.out.println("Danh sách sự kiện:");
        eventList.forEach(System.out::println);

        //Hiển thị danh sách sự kiện theo thời gian bắt đầu
        List<Event> eventList1 = new ArrayList<>(eventList);
        eventList1.sort(Comparator.comparing(Event::getStartTime));
        System.out.println("Danh sách sự kiện theo thứ tự thời gian bắt đầu:");
        eventList1.forEach(System.out::println);

        //Hiển thị danh sách sự kiện theo thứ thự thời lượng tăng dần
        List<Event> eventList2 = new ArrayList<>(eventList);
        System.out.println("Danh sách sự kiện theo thứ tự thời lượng tăng dần:");
        eventList2.sort(Comparator.comparing(Event::getDuration));
        eventList2.forEach(System.out::println);

        //Hiển thị danh sách sự kiện theo thòi
        //Tìm kiếm
        for (Event t: eventList) {
            if (t.getName().equalsIgnoreCase("Họp nhóm"))
            {
                System.out.println("Đã tìm thấy sự kiện");
                break;
            }
        }

        //Xóa
        eventList.removeIf(event -> event.getName().equalsIgnoreCase("Sự kiện A"));
        System.out.println("Danh sách sự kiện sau khi xóa:");
        eventList.forEach(System.out::println);


    }
}
