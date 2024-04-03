package amazon;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class P10 {
    /**
     * O(n log n) time and O(1) space complexities
     * 
     * @param a
     * @param n
     * @return
     */
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

    /**
     * O(n) time and O(1) space complexities
     * 
     * Steps:
     * 1. For each value in the array add 'n' at the index of the value. For eg, if
     * value is 2 add 'n' at index 2.
     * 2. Iterate for the second time through the array and any time the value at
     * and index is >= 2*n, it means that there are atleast 2 occurrences
     * of that index in the original array.
     * 
     * @param a
     * @param n
     * @return
     */
    private static ArrayList<Integer> solution2(int[] a, int n) {
        ArrayList<Integer> out = new ArrayList<>();

        for (int x : a) {
            // since 'n' might have been added to the values
            // we take the remainder after dividing with n
            x = x % n;
            a[x] += n;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 2 * n) {
                out.add(i);
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