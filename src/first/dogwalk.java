package first;

import java.util.Arrays;
import java.util.Scanner;

public class dogwalk {
    public static void main(String[] args) {
        char[][] arr = new char[10][10];
        int hp = 100;
        int bomb = 20;
        int aid = 20;
        int positionFirst = 0;
        int positionSecond = 0;
        int bombPositionFirst;
        int bombPositionSecond;
        int aidPositionFirst = (int) (Math.random() * (arr.length - 2) + 1);
        int aidPositionSecond = (int) (Math.random() * (arr.length - 2) + 1);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '_';
                arr[0][0] = '@';
            }
        }
        do {
            bombPositionFirst = (int) (Math.random() * (arr.length - 2) + 1);
            bombPositionSecond = (int) (Math.random() * (arr.length - 2) + 1);
        } while (bombPositionFirst == aidPositionFirst && bombPositionSecond == aidPositionSecond);
        arr[bombPositionFirst][bombPositionSecond] = '*';
        arr[aidPositionFirst][aidPositionSecond] = '+';

        do {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            String user = scanner.nextLine();
            switch (user) {
                case "a":
                    arr[positionFirst][positionSecond--] = '_';
                    if (positionSecond < 0) {
                        positionSecond = 9;
                        arr[positionFirst][positionSecond] = '@';
                        arr[positionFirst][0] = '_';
                    }
                    arr[positionFirst][positionSecond] = '@';
                    break;
                case "d":
                    arr[positionFirst][positionSecond++] = '_';
                    if (positionSecond == arr.length) {
                        positionSecond = 0;
                        arr[positionFirst][9] = '_';
                        arr[positionFirst][positionSecond] = '@';
                    }
                    arr[positionFirst][positionSecond] = '@';
                    break;
                case "w":
                    arr[positionFirst--][positionSecond] = '_';
                    if (positionFirst < 0) {
                        positionFirst = 9;
                        arr[positionFirst][positionSecond] = '@';
                        arr[positionFirst][positionSecond] = '_';
                    }
                    arr[positionFirst][positionSecond] = '@';
                    break;
                case "s":
                    if (positionFirst == arr.length - 1) {
                        positionFirst = 0;
                        arr[9][positionSecond] = '_';
                        arr[positionFirst][positionSecond] = '@';
                    } else {
                        arr[positionFirst++][positionSecond] = '_';
                        arr[positionFirst][positionSecond] = '@';
                    }
                    break;
            }

            if (arr[positionFirst][positionSecond] == arr[bombPositionFirst][bombPositionSecond]) {
                hp -= bomb;
            } else if (arr[positionFirst][positionSecond] == arr[aidPositionFirst][aidPositionSecond]) {
                hp += aid;
            }
            hp -= 5;
            System.out.println(hp);
            if (hp <= 0 || (positionFirst == 9 && positionSecond == 9)) {
                System.out.println("You are lose");
                break;
            }
        } while (true);
    }
}