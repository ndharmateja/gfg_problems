package amazon.arrays;

import java.util.ArrayList;
import java.util.HashSet;

@SuppressWarnings("unused")
public class P7 {
    /**
     * ref:
     * https://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes/
     * Step-by-step algorithm:
     * 
     * Initially, keep a variable (p = 1).
     * Traverse the array from start to end.
     * While traversing, check whether p is divisible by the i-th element. If true,
     * then erase that element.
     * Else keep that element and update the product by multiplying that element
     * with the product (p = p * arr[i])
     */
    ArrayList<Integer> solution1(int[] a, int n) {
        ArrayList<Integer> out = new ArrayList<>();
        long p = 1;
        for (int x : a) {
            if (p % x != 0) {
                out.add(x);
                p *= x;
            }
        }
        return out;
    }

    ArrayList<Integer> solution2(int[] a, int n) {
        ArrayList<Integer> out = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int x : a) {
            if (!set.contains(x)) {
                out.add(x);
                set.add(x);
            }
        }
        return out;
    }

    ArrayList<Integer> removeDuplicate(int[] a, int n) {
        return solution2(a, n);
    }

    public static void main(String[] args) {
        new P7().removeDuplicate(new int[] { 2, 2, 3, 3, 7, 5 }, 0);
    }
}
