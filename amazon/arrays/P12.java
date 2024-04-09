package amazon.arrays;

public class P12 {
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void convertToWave(int n, int[] a) {
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && a[i] < a[i + 1])
                swap(a, i, i + 1);
            if (i % 2 == 1 && a[i] > a[i + 1])
                swap(a, i, i + 1);
        }
    }
}
