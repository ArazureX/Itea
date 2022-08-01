package homework5;

import java.util.Arrays;
import java.util.Scanner;

public class hm5_4 {
    public static void main(String[] args) {
       // char[] arr = {'@', '_', '_', '_', '_', '_', '_', '_', '_', '_' };
        char[] arr = new char[10];

        int dogPosition = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isWin = false;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = '_';
        }
        arr[0] = '@';

        System.out.println("Welcome to Dog Game");
        System.out.println("For move forward type 'd' go back type 'a' ");


        do {

            String user = scanner.nextLine();
            switch (user) {
                case "d":
                    arr[dogPosition + 1] = '@';
                    dogPosition++;
                    arr[dogPosition - 1] = '_';
                    break;

                case "a":
                    arr[dogPosition - 1] = '@';
                    dogPosition--;
                    arr[dogPosition +1 ] = '_';
                    break;
            }
            if (arr[arr.length - 1] == '@') {
                isWin = true;
            }
            System.out.println(Arrays.toString(arr));

        } while (isWin == false);
        System.out.println(isWin ? "You win" : "You lose");
    }
}
