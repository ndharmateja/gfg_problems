package amazon.arrays;

import java.util.ArrayList;

// TODO
public class P17 {
    // Brute force
    // O(n^2) time and O(1) space complexities
    private static ArrayList<Integer> solution1(int[] arr, int n, int s) {
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // s is equal to the sum of elements from i to j (inclusive)
                // So we return the array list with i+1 and j+1 as we need to return
                // in 1-based
                if (sum == s) {
                    out.add(i + 1);
                    out.add(j + 1);
                    return out;
                }
            }
        }

        // If we reach here
        // it means no subarray was found to the given sum
        out.add(-1);
        return out;
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        return solution1(arr, n, s);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
