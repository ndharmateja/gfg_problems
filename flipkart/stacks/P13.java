package flipkart.stacks;

public class P13 {
    private static boolean isSquare(int x) {
        return x == 1;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int numSquareStudents = 0;
        int numSquareSandwiches = 0;
        for (int student : students) {
            if (isSquare(student))
                numSquareStudents++;
        }
        for (int sandwich : sandwiches) {
            if (isSquare(sandwich))
                numSquareSandwiches++;
        }

        int numCircleStudents = n - numSquareStudents;
        int numCircleSandwiches = n - numSquareSandwiches;

        return Integer.max(0, numSquareStudents - numSquareSandwiches)
                + Integer.max(0, numCircleStudents - numCircleSandwiches);
    }
}
