package amazon.arrays;

public class P13 {
    public static int equilibriumPoint(long arr[], int n) {
        // base case
        if (n == 1)
            return 1;

        // convert array into cumulative sums
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        // {1, 3, 5, 2, 2}
        // {1, 4, 9, 11, 13}
        for (int i = 0; i < n; i++) {
            long beforeSum = i == 0 ? 0 : arr[i - 1];
            long afterSum = arr[n - 1] - arr[i];

            // if both are same, return index in 1-based
            if (beforeSum == afterSum)
                return i + 1;
        }

        // if no index found
        return -1;
    }
}
