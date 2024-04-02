package amazon;

import java.util.ArrayList;

public class P3 {
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int a[]) {
        // Maintain the top 2 max elements
        // and skip elements already equal to them
        // Can be initialized to -1 as all elements are +ve
        // and also default return value in case of duplicates is -1
        int xMax, xMaxest;
        xMax = xMaxest = -1;
        for (int x : a) {
            if (x > xMaxest) {
                xMax = xMaxest;
                xMaxest = x;
            } else if (x == xMaxest) {
                continue;
            } else if (x > xMax) {
                xMax = x;
            }
        }

        // Create and return the array list

        ArrayList<Integer> list = new ArrayList<>();
        list.add(xMaxest);
        list.add(xMax);
        return list;
    }
}
