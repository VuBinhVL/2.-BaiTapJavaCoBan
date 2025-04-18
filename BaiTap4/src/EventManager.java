import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
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

    // Tính thời lượng sự kiện
    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    // So sánh dựa trên thời lượng sự kiện
    @Override
    public int compareTo(Event other) {
        return this.getDuration().compareTo(other.getDuration());
    }

    @Override
    public String toString() {
        return String.format("Sự kiện: %s | Bắt đầu: %s | Kết thúc: %s | Thời lượng: %d phút",
                name, startTime, endTime, getDuration().toMinutes());
    }
}

public class EventManager {
    private List<Event> events = new ArrayList<>();

    // Thêm sự kiện
    public void addEvent(Event event) {
        events.add(event);
    }

    // Hiển thị danh sách sự kiện theo thời gian bắt đầu
    public void displayEventsByStartTime() {
        events.sort(Comparator.comparing(Event::getStartTime));
        System.out.println("Danh sách sự kiện theo thứ tự thời gian bắt đầu:");
        events.forEach(System.out::println);
    }

    // Hiển thị các sự kiện sắp diễn ra
    public void displayUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> upcomingEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getStartTime().isAfter(now)) {
                upcomingEvents.add(event);
            }
        }
        upcomingEvents.sort(Comparator.comparing(Event::getStartTime));
        System.out.println("Danh sách sự kiện sắp diễn ra:");
        upcomingEvents.forEach(System.out::println);
    }



    // Tìm kiếm sự kiện theo tên
    public Event findEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    // Xóa sự kiện theo tên
    public void removeEventByName(String name) {
        events.removeIf(event -> event.getName().equalsIgnoreCase(name));
    }

    // Sắp xếp các sự kiện theo thời lượng tăng dần
    public void sortEventsByDuration() {
        Collections.sort(events);
        System.out.println("Danh sách sự kiện theo thời lượng tăng dần:");
        events.forEach(System.out::println);
    }

    public static void main(String[] args) {
        EventManager manager = new EventManager();

        // Thêm các sự kiện mẫu
        manager.addEvent(new Event("Cuộc họp A", LocalDateTime.of(2024, 4, 10, 9, 0),
                LocalDateTime.of(2024, 4, 10, 10, 0)));
        manager.addEvent(new Event("Hội thảo B", LocalDateTime.of(2024, 4, 12, 14, 0),
                LocalDateTime.of(2024, 4, 12, 16, 30)));
        manager.addEvent(new Event("Tiệc công ty", LocalDateTime.of(2024, 4, 15, 18, 0),
                LocalDateTime.of(2024, 4, 15, 22, 0)));
        manager.addEvent(new Event("Học lập trình", LocalDateTime.of(2024, 4, 8, 20, 0),
                LocalDateTime.of(2024, 4, 8, 22, 0)));

        // Hiển thị danh sách theo thời gian bắt đầu
        manager.displayEventsByStartTime();

        // Hiển thị các sự kiện sắp diễn ra
        manager.displayUpcomingEvents();

        // Tìm kiếm sự kiện theo tên
        String searchName = "Hội thảo B";
        Event foundEvent = manager.findEventByName(searchName);
        if (foundEvent != null) {
            System.out.println("Tìm thấy sự kiện: " + foundEvent);
        } else {
            System.out.println("Không tìm thấy sự kiện có tên: " + searchName);
        }

        // Xóa một sự kiện theo tên
        manager.removeEventByName("Học lập trình");
        System.out.println("\nDanh sách sau khi xóa 'Học lập trình':");
        manager.displayEventsByStartTime();

        // Sắp xếp các sự kiện theo thời lượng
        manager.sortEventsByDuration();
    }
}
