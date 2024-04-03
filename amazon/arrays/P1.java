package amazon.arrays;

@SuppressWarnings("unused")
public class P1 {
    private int solution1(int num) {
        // base case
        if (num == 0)
            return 5;

        // Get each digit and if it is a 0 use 5
        // and add at the start of new number
        // That is why we maintain 'prod'
        // if curr digit is 4 and we need to add at start of 55, prod is 100
        // it will be 4 * prod + 55 = 455 and prod will become 1000
        int prod = 1;
        int newNum = 0;
        while (num > 0) {
            int digit = num % 10;
            int newDigit = digit == 0 ? 5 : digit;
            newNum = newDigit * prod + newNum;

            prod *= 10;
            num /= 10;
        }

        return newNum;
    }

    private int reverse(int num) {
        int reverse = 0;
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }

    private int solution2(int num) {
        // base case
        if (num == 0)
            return 5;

        int newNum = 0;
        while (num > 0) {
            int digit = num % 10;
            int newDigit = digit == 0 ? 5 : digit;
            newNum = newNum * 10 + newDigit;
            num /= 10;
        }

        return reverse(newNum);
    }

    public int convertfive(int num) {
        return solution1(num);
    }

    public static void main(String[] args) {
        System.out.println(new P1().convertfive(1203));
        System.out.println(new P1().convertfive(1203));
    }
}