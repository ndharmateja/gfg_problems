package flipkart.strings;

import java.util.HashMap;

public class P5 {
    private static HashMap<Character, Integer> getCharCounts(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public static char nonrepeatingCharacter(String s) {
        HashMap<Character, Integer> counts = getCharCounts(s);
        for (char c : s.toCharArray()) {
            if (counts.get(c) == 1)
                return c;
        }
        return '$';
    }
}
