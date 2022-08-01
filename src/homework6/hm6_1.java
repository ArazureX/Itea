package homework6;

import java.util.Arrays;
import java.util.Scanner;

public class hm6_1 {
    public static void main(String[] args) {
        char[][] arr = new char[10][10];

        int dogPosition = 0;
        int dogPositionVertical = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isWin = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '_';
            }
        }
        arr[0][0] = '@';

        System.out.println("Welcome to Dog Game");
        System.out.println("For move forward type 'd' go back type 'a' ");


        do {

            String user = scanner.nextLine();
            switch (user) {
                case "d":
                    if (dogPosition >= arr.length - 1) {
                        arr[dogPositionVertical][0] = '@';
                        arr[dogPositionVertical][arr.length - 1] = '_';
                        dogPosition = 0;
                    } else {
                        arr[dogPositionVertical][++dogPosition] = '@';
                        arr[dogPositionVertical][dogPosition - 1] = '_';
                    }
                    break;

                case "a":
                    if (dogPosition <= 0) {
                        arr[dogPositionVertical][arr.length - 1] = '@';
                        arr[dogPositionVertical][0] = '_';
                        dogPosition = arr.length - 1;
                    } else {
                        arr[dogPositionVertical][--dogPosition] = '@';
                        arr[dogPositionVertical][dogPosition + 1] = '_';
                    }
                    break;
                case "s":
                    if (dogPositionVertical >= arr.length - 1) {
                        arr[0][dogPosition] = '@';
                        arr[arr.length - 1][dogPosition] = '_';
                        dogPositionVertical = 0;
                    } else {
                        arr[++dogPositionVertical][dogPosition] = '@';
                        arr[dogPositionVertical - 1][dogPosition] = '_';
                    }
                    break;
                case "w":
                    if (dogPositionVertical <= 0) {
                        arr[arr.length - 1][dogPosition] = '@';
                        arr[0][dogPosition] = '_';
                        dogPositionVertical = arr.length - 1;
                    } else {
                        arr[--dogPositionVertical][dogPosition] = '@';
                        arr[dogPositionVertical + 1][dogPosition] = '_';
                    }
                    break;
            }
            if (arr[arr.length - 1][arr.length - 1] == '@') {
                isWin = true;
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }

        } while (isWin == false);
        System.out.println(isWin ? "You win" : "You lose");
    }
}
