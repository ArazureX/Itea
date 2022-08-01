package homework5;

import java.util.Arrays;

public class hm5_3 {
    public static void main(String[] args) {

        byte[] byteArr = new byte[10];
        short[] shortArr = new short[10];
        int[] intArr = new int[10];
        int countByte = 0;
        int countShort = 0;
        int countInt = 0;
        int countAll = 0;

        do {
            int number = (int) (Math.random() * 2147483646);
            countAll++;
            if (number <= 127) {
                if (countByte == 10) continue;
                byteArr[countByte] = (byte) number;
                countByte++;
            } else if (number <= 32767) {
                if (countShort == 10) continue;
                shortArr[countShort] = (short) number;
                countShort++;
            } else {
                if (countInt == 10) continue;
                intArr[countInt] = (int) number;
                countInt++;
            }
        } while (byteArr[byteArr.length - 1] == 0);
        System.out.println(countAll);
        System.out.println(Arrays.toString(byteArr));
        System.out.println(Arrays.toString(shortArr));
        System.out.println(Arrays.toString(intArr));
    }
}
