package homework18;

public class GunselPassenger {
    private String name;
    private int place;

    public GunselPassenger(String name, int place) {
        this.name = name;
        this.place = place;
    }

    @Override
    public String toString() {
        return "GunselPassenger{" +
                "name='" + name + '\'' +
                ", place=" + place +
                '}';
    }
}
