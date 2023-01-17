package TwoPointers;

public class ValidPalindromeLenient {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (isPalindromeStrict(s.substring(left + 1, right + 1))) {
                return true;
            } else {
                return isPalindromeStrict(s.substring(left, right));
            }
        }

        return true;
    }

    private static boolean isPalindromeStrict(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("RACEACAR"));
    }
}
