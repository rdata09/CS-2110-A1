package cs2110;

/*
 * Assignment metadata
 * Name and NetID: Ryan Gomez rg673
 * Hours spent on assignment: 2
 */

/**
 * Collection of misc. static functions for showcasing the capabilities of Java in a procedural
 * context.
 */
public class A1 {

    /**
     * Return the area of a regular polygon with `nSides` sides of length `sideLength`. Units of
     * result are the square of the units of `sideLength`. Requires `nSides` is at least 3,
     * `sideLength` is non-negative.
     */
    public static double polygonArea(int nSides, double sideLength) {
        double result = (1.0/4.0 * Math.pow(sideLength, 2) * (nSides / Math.tan(Math.PI / nSides)) );
        return result;
    }

    /**
     * Return the next term in the Collatz sequence after the argument.  If the argument is even,
     * the next term is it divided by 2.  If the argument is odd, the next term is 3 times it plus
     * 1.  Requires magnitude of odd `x` is less than `Integer.MAX_VALUE/3` (otherwise overflow is
     * possible).
     */
    public static int nextCollatz(int input) {
        if (input % 2 == 0) { //4 spit out 2
            return input/2;
        }
        else {
            return input * 3 + 1; //5 spit out 3 * 5 = 15, then + 1 = 16
        }
    }

    /**
     * Return the sum of the Collatz sequence starting at `seed` and ending at 1 (inclusive).
     * Requires `seed` is positive, sum does not overflow.
     */
    public static int collatzSum(int seed) { //=10
        // Implementation constraint: Use a while-loop.  Call `nextCollatz()` to
        // advance the sequence.
        int back_sum = seed; // = 10
        while (seed <= 1) { //take 10, then run it through nextCollatz()
            seed = nextCollatz(seed); //10/2 = 5
            back_sum += seed; //10 + 5 = 15
        }
        return back_sum;
    }

    /**
     * Return the median value among `{a, b, c}`.  The median has the property that at least half of
     * the elements are less than or equal to it and at least half of the elements are greater than
     * or equal to it.
     */
    public static int med3(int a, int b, int c) {
        // Implementation constraint: Do not call any other methods.
        if (a <= b && c >= b || a >= b && c <= b) {
            return b;
        }
        if (b <= a && c >=a || b >= a && c <= a) {
            return a;
        }
        else {
            return c;
        }
    }

    /**
     * Return whether the closed intervals `[lo1, hi1]` and `[lo2, hi2]` overlap.  Two intervals
     * overlap if there exists a number contained in both of them.  Notation: the interval `[lo,
     * hi]` contains all numbers greater than or equal to `lo` and less than or equal to `hi`.
     * Requires `lo1` is less than or equal to `hi1` and `lo2` is less than or equal to `hi2`.
     */
    public static boolean intervalsOverlap(int lo1, int hi1, int lo2, int hi2) {
        // Implementation constraint: Use a single return statement to return
        // the value of a Boolean expression; do not use an if-statement.
        return hi1 >= lo2 && hi2 >= lo1;
    }

    /**
     * Return the approximation of pi computed from the sum of the first `nTerms` terms of the
     * Madhava-Leibniz series.  This formula states that pi/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
     * Requires `nTerms` is non-negative.
     */
    public static double estimatePi(int nTerms) { // = 2
        // Implementation constraint: Use a for-loop.  Do not call any other
        // methods (including `Math.pow()`).
        double sum = 0.0;
        for (int x = 0; nTerms > x; x++) {
            double denom = 2.0 * x +1.0;
            if (x % 2 == 0) {
                sum += 1.0/(denom);
            }
            else {
                sum -= 1.0/(denom);
            }
        }
        return sum * 4;
    }

    /**
     * Returns whether the sequence of characters in `s` is equal (case-sensitive) to that sequence
     * in reverse order.
     */
    public static boolean isPalindrome(String s) {
        // Implementation constraint: Use the `charAt()` and `length()` methods
        // of the `String` class.
        int i = 1;
        for (int x = 0; x <= s.length()-i; x++) {
            if (s.charAt(x) == s.charAt(s.length()-i)) {
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * Return an order confirmation message in English containing the order ID and the number of
     * items it contains.  Message shall handle item plurality properly (e.g. "1 item" vs. "3
     * items") and shall surround the order ID in single quotes. Examples:
     * <pre>
     * formatConfirmation("123ABC", 1) should return
     *   "Order '123ABC' contains 1 item."
     * formatConfirmation("XYZ-999", 3)" should return
     *   "Order 'XYZ-999' contains 3 items."
     * </pre>
     * Requires `orderId` only contains digits, hyphens, or letters 'A' - 'Z'; `itemCount` is
     * non-negative.
     */
    public static String formatConfirmation(String orderId, int itemCount) {
        // Implementation constraint: Use Java's ternary operator (`?:`) to give "item" the
        // appropriate plurality.
        String item = String.format("%d", itemCount);
        String plural = (itemCount != 1) ? ("items") : ("item");
        return "Order \'" + orderId + "\' contains " + item + " " + plural + ".";
    }
    public static void main(String[] args) {
        int collatzSum = collatzSum(1);
        int medium = med3(1,2,3);
        double poly = polygonArea(medium, estimatePi(3));
    }

}
