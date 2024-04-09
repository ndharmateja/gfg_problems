package amazon.arrays;

import java.util.Arrays;

public class P15 {
    public static long[] productExceptSelf(int nums[], int n) {
        if (n == 1)
            return new long[] { 1L };

        long[] pre = new long[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        long[] post = new long[n];
        post[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }

        long[] result = new long[n];
        result[0] = post[1];
        result[n - 1] = pre[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = pre[i - 1] * post[i + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 10, 3, 5, 6, 2 }, 5)));
    }
}
