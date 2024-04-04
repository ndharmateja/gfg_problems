package flipkart.strings;

public class P4 {
    public static int binarySubstring(int a, String str) {
        int numOnes = 0;
        for (char c : str.toCharArray()) {
            if (c == '1')
                numOnes++;
        }

        return numOnes * (numOnes - 1) / 2;
    }
}
