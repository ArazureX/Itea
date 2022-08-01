package homework7;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class hm7_1 {
    public static void main(String[] args) {

        String[][] arr = new String[3][3];
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                switch (j) {
                    case 0:
                        System.out.println("Type fio number# " + i);
                        break;
                    case 1:
                        System.out.println("Type address number# " + i);
                        break;
                    case 2:
                        System.out.println("Type age number# " + i);
                        break;
                }
                String userInput = scanner.nextLine();
                arr[i][j] = userInput;
            }
        }
        do {
            System.out.println("Type search request");
            String userSearch = scanner.nextLine();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (userSearch.toLowerCase().equals("quit"))
                        isQuit = false;
                    if (arr[i][j].toLowerCase().contains(userSearch.toLowerCase())) {
                        System.out.println(Arrays.toString(arr[i]));
                    }
                }
            }
        } while (isQuit);
        scanner.close();
        System.out.println("System close");
    }
}

