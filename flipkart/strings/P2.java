package flipkart.strings;

import java.util.HashMap;

public class P2 {
    private static HashMap<Character, Integer> getCharCounts(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public static char getMaxOccuringChar(String s) {
        HashMap<Character, Integer> counts = getCharCounts(s);

        char maxChar = '0';
        int maxCount = 0;
        for (char c : counts.keySet()) {
            int count = counts.get(c);
            if (count > maxCount) {
                maxChar = c;
                maxCount = count;
            } else if (count == maxCount && c < maxChar) {
                maxChar = c;
            }
        }

        return maxChar;
    }
}
