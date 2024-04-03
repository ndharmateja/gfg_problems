package amazon.arrays;

import java.util.HashSet;

public class P26 {
    public static int solution1(int[] a, int[] b, int n, int m) {
        HashSet<Integer> setA = new HashSet<>();
        for (int x : a) {
            setA.add(x);
        }

        HashSet<Integer> setB = new HashSet<>();
        for (int x : b) {
            setB.add(x);
        }

        int count = 0;
        for (int x : setB) {
            if (setA.contains(x))
                count++;
        }

        return count;
    }

    public static int NumberofElementsInIntersection(int[] a, int[] b, int n, int m) {
        return solution1(a, b, n, m);
    }
}
