package amazon.arrays;

public class P5 {
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            swap(a, l++, r--);
        }
    }

    public static void rotateArr(int[] a, int d, int n) {
        d = d % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, n - d - 1);
        reverse(a, n - d, n - 1);
    }
}
