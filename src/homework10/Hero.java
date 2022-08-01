package homework10;

import java.util.*;

public abstract class Hero implements Cloneable {
    protected int inteligence;
    protected int agility;
    protected int strange;
    protected int hitPower;
    private int health = 100;
    private String name;

    private Item item;

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStrange(int strange) {
        this.strange = strange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void calcucateHitPower();

    public abstract int damegeBonus();

    public Item getItemFromHashSet(HashSet<Item> hs) {
        List<Item> items = new ArrayList<>(hs);
        return items.get((int) (Math.random() * items.size()));
    }

    public void setItem(Item item) {
        this.item = item;
        inteligence += item.getInteligence();
        agility += item.getAgility();
        strange += item.getStrange();
        hitPower += item.getStrange() / 3 + item.getInteligence() / 2 + item.getAgility();
    }

    public void sellItem(Item item) {
        this.item = null;
        inteligence -= item.getInteligence();
        agility -= item.getAgility();
        strange -= item.getStrange();
        hitPower -= item.getStrange() / 3 + item.getInteligence() / 2 + item.getAgility();
    }


    public void takeDamage(double damage) {
        health -= damage;
    }


    public int getHealth() {
        return health;
    }


    public int getHitPower() {
        return hitPower;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ("\nHero name: " + name + "\nIntelige: " + inteligence + "\nAgility: " + agility + "\nStrange: " + strange + "\nHit Power: " + hitPower + "\n" + "Health: "
                + health + "\n" + "Items: " + "\n");
    }

    public void compareHeroes(Hero a, Hero b) throws MyException {
        if ((a.equals(b) == true) && (a.hashCode() == b.hashCode())) {
            throw new MyException("Heroes are the same");
        } else {
            System.out.println("Heroes are different, cool");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return inteligence == hero.inteligence && agility == hero.agility && strange == hero.strange && hitPower == hero.hitPower && health == hero.health && Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inteligence, agility, strange, hitPower, health, name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Item cloneItem = (Item) item.clone();
        Hero clonHero = (Hero) super.clone();
        clonHero.setItem(cloneItem);
        return clonHero;
    }
}


