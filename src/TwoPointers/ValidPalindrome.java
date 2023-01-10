package TwoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        String[] testCase = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println("-".repeat(100));
            System.out.println("\tThe input string is '" + testCase[k] + "' and the length of the string is " + testCase[k].length() + ".");
            System.out.println("\n\tIs it a palindrome?..... " + isPalindrome(testCase[k]));
            System.out.println("-".repeat(100));
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = s.charAt(left) == s.charAt(right);

        while (isPalindrome && left < right) {
            left = left + 1;
            right = right - 1;
            isPalindrome = s.charAt(left) == s.charAt(right);
        }

        return isPalindrome;
    }
}
