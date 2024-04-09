package amazon.arrays;

// TODO
public class P14 {
    public int FindMaxSum(int arr[], int n) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                evenSum += arr[i];
            else
                oddSum += arr[i];
        }
        return Integer.max(evenSum, oddSum);
    }
}
