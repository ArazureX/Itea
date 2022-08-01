package homework10;

public class Pudge extends Hero {
    private int maxRandomNumber = 10;



    private int getRandomNumber() {
        return (int) (Math.random() * (maxRandomNumber));
    }

    @Override
    public void calcucateHitPower() {
        hitPower = strange / 3 + inteligence / 2 + agility;

    }

    public int getHitPower(){

        return hitPower;
    }

    @Override
    public int damegeBonus() {
        int damageBonus;
        switch (getRandomNumber()) {
            case 1, 2:
                damageBonus = 0; //its Evasion
                System.out.println("Missed");;
                break;
            case 3, 4:
                damageBonus = 3; // its critical strike
                System.out.println("Crritical Hit");
                break;
            default:
                damageBonus = 1; // without bonus
                break;
        }
        return damageBonus;
    }


}
