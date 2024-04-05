package amazon.linkedlists;

import java.util.HashSet;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class P26 {
    private static int solution1(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        int pairs = 0;
        for (int x1 : head1)
            for (int x2 : head2)
                if (x1 + x2 == x)
                    pairs++;

        return pairs;
    }

    private static int solution2(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int x1 : head1)
            set.add(x1);

        int pairs = 0;
        for (int x2 : head2)
            if (set.contains(x - x2))
                pairs++;

        return pairs;
    }

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        return solution2(head1, head2, x);
    }
}
