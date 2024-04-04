package mustdo.arrays;

import java.util.ArrayList;

public class P1 {
    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static void reverseList(ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            swap(list, l++, r--);
        }
    }

    public static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leaders = new ArrayList<>();

        // Iterate from right to left to find the leaders
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            // if a leader is found add at the end of the array list
            int curr = arr[i];
            if (curr >= maxSoFar) {
                maxSoFar = curr;
                leaders.add(curr);
            }
        }

        // All the leaders are in reverse order
        // so we reverse the list and return;
        reverseList(leaders);
        return leaders;
    }
}