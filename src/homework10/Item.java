package homework10;

public class Item implements Cloneable{

    private int inteligence;
    private int agility;
    private int strange;
    private String name;

    public Item(int inteligence, int agility, int strange, String name) {
        this.inteligence = inteligence;
        this.agility = agility;
        this.strange = strange;
        this.name = name ;
    }

    public int getInteligence() {
        return inteligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrange() {
        return strange;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Item{" +
                "inteligence=" + inteligence +
                ", agility=" + agility +
                ", strange=" + strange +
                ", name='" + name + '\'' +
                '}';
    }
}
