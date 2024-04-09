package microsoft.arrays;

import java.util.ArrayList;

public class P2 {
    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static void reverse(ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r)
            swap(list, l++, r--);
    }

    public static ArrayList<Integer> increment(ArrayList<Integer> list, int n) {
        reverse(list);

        list.set(0, list.get(0) + 1);
        for (int i = 0; i < n; i++) {
            // If digit equals 10
            // make it 0
            // and increment the next digit
            if (list.get(i) == 10) {
                list.set(i, 0);

                // If i is the end
                // then add a new 1 at the end of the list
                if (i == n - 1) {
                    list.add(1);
                    break;
                }
                // else increment the next digit
                else {
                    list.set(i + 1, list.get(i + 1) + 1);
                }
            }
            // If digit is less than 10
            // we can stop the loop here
            else {
                break;
            }
        }

        reverse(list);
        return list;
    }
}
