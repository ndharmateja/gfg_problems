package amazon.arrays;

public class P2 {
    public int thirdLargest(int a[], int n) {
        if (n < 3)
            return -1;

        // Maintain the top 3 largest values
        int xMax, xMaxer, xMaxest;
        xMax = xMaxer = xMaxest = Integer.MIN_VALUE;
        for (int x : a) {
            if (x > xMaxest) {
                xMax = xMaxer;
                xMaxer = xMaxest;
                xMaxest = x;
            } else if (x > xMaxer) {
                xMax = xMaxer;
                xMaxer = x;
            } else if (x > xMax) {
                xMax = x;
            }
        }

        return xMax;
    }
}
