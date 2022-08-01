package homework5;

import java.util.Arrays;

public class hm5_1 {
    public static void main(String[] args) {

        int length = (int) (Math.random() * 5 + 5);
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            int number = (int) (Math.random() * 101);
            arr[i] = number;
        }
        System.out.println("Array length = " + length);
        System.out.println(Arrays.toString(arr));
    }
}

