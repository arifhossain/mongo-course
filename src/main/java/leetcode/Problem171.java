package leetcode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 */

public class Problem171 {

    public int titleToNumber(String s) {
        int sum = 0;

        char[] letters = s.toCharArray();
        for (int i = letters.length - 1; i >= 0; i--) {
            int asciiValue = letters[i] - 'A' + 1;
            sum = sum + (asciiValue * (int)Math.pow(26, letters.length - i - 1));
        }

        return sum;
    }

    public static void main(String[] args) {
        Problem171 solution = new Problem171();

        System.out.println("D -> " + solution.titleToNumber("D"));
        System.out.println("AA -> " + solution.titleToNumber("AA"));
        System.out.println("AG -> " + solution.titleToNumber("AG"));
        System.out.println("AAA -> " + solution.titleToNumber("AAA"));
    }
}
