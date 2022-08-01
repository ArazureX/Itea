package homework5;

import java.util.Arrays;

public class hm5_2 {
    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            arr[i] = 28 + (arr[i] + (arr[i] / 8)) % 2 + 2 % arr[i] + 2 * (1 / arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
}
