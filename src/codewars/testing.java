package codewars;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class testing {
    public static void main(String[] args) {
        String str = "two word";
        String[] result = new String[str.replaceAll("\\s", "").length()];
        int spaceCount = 0;
        for (int i = 0; i  < result.length+spaceCount; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
                continue;
            }
            result[i - spaceCount] = str.substring(0, i ) + str.substring(i, i + 1).toUpperCase() + str.substring(i + 1);
        }
        System.out.println(Arrays.toString(result));
    }
}


