package flipkart.strings;

public class P7 {
    public int isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return 0;
        }
        return 1;
    }
}
