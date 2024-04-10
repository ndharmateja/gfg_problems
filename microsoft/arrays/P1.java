package microsoft.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class P1 {
    private static boolean isNum1Greater(String num1, String num2) {
        if (num1.length() > num2.length())
            return true;
        if (num1.length() < num2.length())
            return false;
        return true;
    }

    public String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String num12 = s1 + s2;
                String num21 = s2 + s1;
                if (isNum1Greater(num12, num21))
                    return -1;
                else
                    return +1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);

        return sb.toString();
    }
}
