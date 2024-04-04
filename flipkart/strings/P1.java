package flipkart.strings;

public class P1 {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public String modify(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!isVowel(chars[l])) {
                l++;
                continue;
            }
            if (!isVowel(chars[r])) {
                r--;
                continue;
            }
            swap(chars, l++, r--);
        }

        return new String(chars);
    }
}
