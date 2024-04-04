package flipkart.strings;

import java.util.HashMap;

public class P10 {
    private static HashMap<Character, Integer> getCharCounts(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        if (a.equals(b))
            return true;
        return getCharCounts(a).equals(getCharCounts(b));
    }
}
