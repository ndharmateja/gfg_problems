package flipkart.strings;

import java.util.HashMap;

public class P9 {
    private static HashMap<Character, Integer> getCharCounts(String s, int start, int end) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public boolean checkIfEqual(String s) {
        int n = s.length();
        int start1 = 0;
        int end1 = n / 2 - 1;
        int start2 = n % 2 == 0 ? end1 + 1 : end1 + 2;
        int end2 = s.length() - 1;

        return getCharCounts(s, start1, end1).equals(getCharCounts(s, start2, end2));
    }
}
