package amazon;

public class P2 {
    public int thirdLargest(int a[], int n) {
        if (n < 3)
            return -1;

        // Maintain the top 3 largest values
        int x1, x2, x3;
        x1 = x2 = x3 = Integer.MIN_VALUE;
        for (int x : a) {
            if (x > x3) {
                x1 = x2;
                x2 = x3;
                x3 = x;
            } else if (x > x2) {
                x1 = x2;
                x2 = x;
            } else if (x > x1) {
                x1 = x;
            }
        }

        return x1;
    }
}
