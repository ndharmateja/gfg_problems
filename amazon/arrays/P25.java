package amazon.arrays;

import java.util.ArrayList;

public class P25 {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> out = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j < m) {
            // if current element is same as previous one
            // we can skip it
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // if elements from both arrays are same, we can add that element to output and
            // move on
            if (arr1[i] == arr2[j]) {
                out.add(arr1[i]);
                i++;
                j++;
                continue;
            }

            // if both are different and not equal to the previous elements
            // we add the smaller one
            if (arr1[i] < arr2[j]) {
                out.add(arr1[i++]);
            } else {
                out.add(arr2[j++]);
            }
        }

        // add the remaining elements from each of the lists
        while (i < n) {
            // if curr element is same as prev, skip it
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            // add element to output
            out.add(arr1[i++]);
        }
        while (j < m) {
            // if curr element is same as prev, skip it
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // add element to output
            out.add(arr2[j++]);
        }

        // return output
        return out;
    }

    public static void main(String[] args) {
        findUnion(new int[] { -7, 8 }, new int[] { -8, -3, 8 }, 2, 3);
    }
}
