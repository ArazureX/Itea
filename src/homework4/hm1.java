package homework4;

public class hm1 {
    public static void main(String[] args) {
/*
        int money = 7700;
        int discount = 0;

        if (money < 300) {
            discount = 0;
        } else if ((money >= 300) && (money < 400)) {
            discount = 3;
        } else if ((money >= 400) && (money < 500)) {
            discount = 5;
        } else {
            discount =7;
        }

        System.out.println("Your discount is " + discount + "%," + "Total to pay "+ (money-((money*discount)/100)) );

*/

        int money = 700;
        int discount = 0;
        int miniMoney = money / 100;

        switch ( miniMoney){
            case 0,1,2 : discount= 0;
                break;
            case 3 : discount= 3;
                break;
            case 4 : discount= 5;
                break;
            default: discount = 7;
                break;
        }
        System.out.println("Your discount is " + discount + "%," + "Total to pay "+ (money-((money*discount)/100)) );
    }
}
