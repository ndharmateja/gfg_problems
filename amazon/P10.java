package amazon;

import java.util.ArrayList;
import java.util.Arrays;

public class P10 {
    private static ArrayList<Integer> solution1(int[] a, int n) {
        ArrayList<Integer> out = new ArrayList<>();

        Arrays.sort(a);
        int curr = a[0];
        boolean duplicateFound = false;
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            if (x == curr) {
                // if occurring for more than second time
                if (duplicateFound)
                    continue;

                // if first duplicate
                duplicateFound = true;
                out.add(x);
            } else {
                curr = x;
                duplicateFound = false;
            }
        }

        if (out.isEmpty())
            out.add(-1);
        return out;
    }

    public static ArrayList<Integer> duplicates(int[] a, int n) {
        return solution1(a, n);
    }
}