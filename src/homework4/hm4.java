package homework4;

import java.util.Scanner;

public class hm4 {
    public static void main(String[] args) {

        int number = (int) (Math.random() * 101);
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        do {
            System.out.println("Try#" + (i++) + ". Enter your number");

            do {
                if (!scanner.hasNextInt()) {
                    System.out.println("Error, Please, enter a digit");
                    scanner.next();
                } else {
                    break;
                }
            } while (true);

            int user = scanner.nextInt();
            if (i == 6) {
                System.out.println("You lost");
                break;
            }
            if (user > number) {
                System.out.println("Wrong! My number is smaller!");
            } else if (user < number) {
                System.out.println("Wrong! My number is bigger!");
            } else {
                System.out.println("You win");
                break;
            }

        } while (true);
    }
}
