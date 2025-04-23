enum Qua
{
    NHO(10), TÁO(24), XOÀI(11), CHANH(99);

    private final int id;
    Qua(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
public class Bai_10_1 {
    public static void main(String[] args) {
        System.out.println("Danh sách quả và ID:");
        for (Qua q: Qua.values()) {
            System.out.println(q + " - ID: " + q.getId());
        }
    }
}
