package amazon.arrays;

public class P4 {
    public int minDist(int a[], int n, int x, int y) {
        int xIndex = -1;
        int yIndex = -1;
        for (int i = 0; i < n; i++) {
            int val = a[i];
            if (val == x) {
                if (xIndex == -1 || yIndex == -1) {
                    xIndex = i;
                } else if (Math.abs(i - yIndex) < Math.abs(xIndex - yIndex)) {
                    xIndex = i;
                }
            } else if (val == y) {
                if (xIndex == -1 || yIndex == -1) {
                    yIndex = i;
                } else if (Math.abs(i - xIndex) < Math.abs(xIndex - yIndex)) {
                    yIndex = i;
                }
            }
        }

        if (xIndex == -1 || yIndex == -1)
            return -1;
        return Math.abs(yIndex - xIndex);
    }
}
