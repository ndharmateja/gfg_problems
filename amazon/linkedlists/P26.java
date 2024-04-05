package amazon.linkedlists;

import java.util.LinkedList;

public class P26 {
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
            int x) {
        int pairs = 0;
        for (int x1 : head1)
            for (int x2 : head2)
                if (x1 + x2 == x)
                    pairs++;

        return pairs;
    }
}
