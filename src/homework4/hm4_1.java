package homework4;

import java.util.Scanner;

public class hm4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sumEven = 0;

        System.out.println("Type your number" );

        do {
            if (!scanner.hasNextInt()) {
                System.out.println("Error, Please, enter a digit");
                scanner.next();
            } else {
                break;
            }
        } while (true);
        int number = scanner.nextInt();
        while (number != 0) {
            if ((number % 10) % 2 == 0) {
                sumEven += number % 10;
            }
            number /= 10;
            count++;
        }

        System.out.println("Your number has " + count  + " digits and sum of even = " + sumEven);

    }
}
