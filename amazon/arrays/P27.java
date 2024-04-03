package amazon.arrays;

public class P27 {
    static int[] SortBinaryArray(int[] a, int n) {
        int numZeroes = 0;
        for (int x : a) {
            if (x == 0)
                numZeroes++;
        }

        for (int i = 0; i < n; i++) {
            a[i] = i < numZeroes ? 0 : 1;
        }

        return a;
    }
}
