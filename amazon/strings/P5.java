package amazon.strings;

public class P5 {
    public int atoi(String s) {
        boolean isNegative = s.charAt(0) == '-';
        int startIndex = isNegative ? 1 : 0;

        int number = 0;
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return -1;

            int digit = c - '0';
            number = 10 * number + digit;
        }

        return isNegative ? -number : number;
    }
}
